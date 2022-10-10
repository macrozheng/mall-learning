package com.macro.mall.tiny.service.impl;

import cn.easyes.core.biz.PageInfo;
import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import cn.hutool.core.util.StrUtil;
import com.macro.mall.tiny.dao.EsProductDao;
import com.macro.mall.tiny.domain.EsProductRelatedInfo;
import com.macro.mall.tiny.easyes.document.EsProduct;
import com.macro.mall.tiny.easyes.mapper.EsProductMapper;
import com.macro.mall.tiny.service.EsProductService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.filter.ParsedFilter;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 搜索商品管理Service实现类
 * Created by macro on 2018/6/19.
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductMapper esProductMapper;
    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        return esProductMapper.insertBatch(esProductList);
    }

    @Override
    public void delete(Long id) {
        esProductMapper.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            result = esProductList.get(0);
            esProductMapper.insert(result);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            esProductMapper.deleteBatchIds(ids);
        }
    }

    @Override
    public PageInfo<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        LambdaEsQueryWrapper<EsProduct> wrapper = new LambdaEsQueryWrapper<>();
        if(StrUtil.isEmpty(keyword)){
            wrapper.matchAllQuery();
        }else{
            wrapper.multiMatchQuery(keyword,EsProduct::getName,EsProduct::getSubTitle,EsProduct::getKeywords);
        }
        return esProductMapper.pageQuery(wrapper, pageNum, pageSize);
    }

    @Override
    public PageInfo<EsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort) {
        LambdaEsQueryWrapper<EsProduct> wrapper = new LambdaEsQueryWrapper<>();
        //过滤
        if (brandId != null || productCategoryId != null) {
            if (brandId != null) {
                wrapper.eq(EsProduct::getBrandId,brandId);
            }
            if (productCategoryId != null) {
                wrapper.eq(EsProduct::getProductCategoryId,productCategoryId).enableMust2Filter(true);
            }
        }
        //搜索
        if (StrUtil.isEmpty(keyword)) {
            wrapper.matchAllQuery();
        } else {
            wrapper.and(i -> i.match(EsProduct::getName, keyword, 10f)
                    .or().match(EsProduct::getSubTitle, keyword, 5f)
                    .or().match(EsProduct::getKeywords, keyword, 2f));
        }
        //排序
        if(sort==1){
            //按新品从新到旧
            wrapper.orderByDesc(EsProduct::getId);
        }else if(sort==2){
            //按销量从高到低
            wrapper.orderByDesc(EsProduct::getSale);
        }else if(sort==3){
            //按价格从低到高
            wrapper.orderByAsc(EsProduct::getPrice);
        }else if(sort==4){
            //按价格从高到低
            wrapper.orderByDesc(EsProduct::getPrice);
        }else{
            //按相关度
            wrapper.sortByScore(SortOrder.DESC);
        }
        return esProductMapper.pageQuery(wrapper, pageNum, pageSize);
    }

    @Override
    public PageInfo<EsProduct> recommend(Long id, Integer pageNum, Integer pageSize) {
        LambdaEsQueryWrapper<EsProduct> wrapper = new LambdaEsQueryWrapper<>();
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            String keyword = esProduct.getName();
            Long brandId = esProduct.getBrandId();
            Long productCategoryId = esProduct.getProductCategoryId();
            //用于过滤掉相同的商品
            wrapper.ne(EsProduct::getId,id);
            //根据商品标题、品牌、分类进行搜索
            wrapper.and(i -> i.match(EsProduct::getName, keyword, 8f)
                    .or().match(EsProduct::getSubTitle, keyword, 2f)
                    .or().match(EsProduct::getKeywords, keyword, 2f)
                    .or().match(EsProduct::getBrandId, brandId, 5f)
                    .or().match(EsProduct::getProductCategoryId, productCategoryId, 3f));
            return esProductMapper.pageQuery(wrapper, pageNum, pageSize);
        }
        return esProductMapper.pageQuery(wrapper, pageNum, pageSize);
    }

    @Override
    public EsProductRelatedInfo searchRelatedInfo(String keyword) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("pms_*");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //搜索条件
        if (StrUtil.isEmpty(keyword)) {
            builder.query(QueryBuilders.matchAllQuery());
        } else {
            builder.query(QueryBuilders.multiMatchQuery(keyword, "name", "subTitle", "keywords"));
        }
        //聚合搜索品牌名称
        builder.aggregation(AggregationBuilders.terms("brandNames").field("brandName"));
        //集合搜索分类名称
        builder.aggregation(AggregationBuilders.terms("productCategoryNames").field("productCategoryName"));
        //聚合搜索商品属性，去除type=1的属性
        AbstractAggregationBuilder<NestedAggregationBuilder> aggregationBuilder = AggregationBuilders.nested("allAttrValues", "attrValueList")
                .subAggregation(AggregationBuilders.filter("productAttrs", QueryBuilders.termQuery("attrValueList.type", 1))
                        .subAggregation(AggregationBuilders.terms("attrIds")
                                .field("attrValueList.productAttributeId")
                                .subAggregation(AggregationBuilders.terms("attrValues")
                                        .field("attrValueList.value"))
                                .subAggregation(AggregationBuilders.terms("attrNames")
                                        .field("attrValueList.name"))));
        builder.aggregation(aggregationBuilder);
        searchRequest.source(builder);
        try {
            SearchResponse searchResponse = esProductMapper.search(searchRequest, RequestOptions.DEFAULT);
            return convertProductRelatedInfo(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将返回结果转换为对象
     */
    private EsProductRelatedInfo convertProductRelatedInfo(SearchResponse response) {
        EsProductRelatedInfo productRelatedInfo = new EsProductRelatedInfo();
        Map<String, Aggregation> aggregationMap = response.getAggregations().asMap();
        //设置品牌
        Aggregation brandNames = aggregationMap.get("brandNames");
        List<String> brandNameList = new ArrayList<>();
        for(int i = 0; i<((Terms) brandNames).getBuckets().size(); i++){
            brandNameList.add(((Terms) brandNames).getBuckets().get(i).getKeyAsString());
        }
        productRelatedInfo.setBrandNames(brandNameList);
        //设置分类
        Aggregation productCategoryNames = aggregationMap.get("productCategoryNames");
        List<String> productCategoryNameList = new ArrayList<>();
        for(int i=0;i<((Terms) productCategoryNames).getBuckets().size();i++){
            productCategoryNameList.add(((Terms) productCategoryNames).getBuckets().get(i).getKeyAsString());
        }
        productRelatedInfo.setProductCategoryNames(productCategoryNameList);
        //设置参数
        Aggregation productAttrs = aggregationMap.get("allAttrValues");
        List<? extends Terms.Bucket> attrIds = ((ParsedStringTerms) ((ParsedFilter) ((ParsedNested) productAttrs).getAggregations().get("productAttrs")).getAggregations().get("attrIds")).getBuckets();
        List<EsProductRelatedInfo.ProductAttr> attrList = new ArrayList<>();
        for (Terms.Bucket attrId : attrIds) {
            EsProductRelatedInfo.ProductAttr attr = new EsProductRelatedInfo.ProductAttr();
            attr.setAttrId(Long.parseLong((String) attrId.getKey()));
            List<String> attrValueList = new ArrayList<>();
            List<? extends Terms.Bucket> attrValues = ((ParsedStringTerms) attrId.getAggregations().get("attrValues")).getBuckets();
            List<? extends Terms.Bucket> attrNames = ((ParsedStringTerms) attrId.getAggregations().get("attrNames")).getBuckets();
            for (Terms.Bucket attrValue : attrValues) {
                attrValueList.add(attrValue.getKeyAsString());
            }
            attr.setAttrValues(attrValueList);
            if(!CollectionUtils.isEmpty(attrNames)){
                String attrName = attrNames.get(0).getKeyAsString();
                attr.setAttrName(attrName);
            }
            attrList.add(attr);
        }
        productRelatedInfo.setProductAttrs(attrList);
        return productRelatedInfo;
    }
}
