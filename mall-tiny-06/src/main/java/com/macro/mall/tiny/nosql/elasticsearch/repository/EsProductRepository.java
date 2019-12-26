package com.macro.mall.tiny.nosql.elasticsearch.repository;

import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 商品ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {  //todo：EsProduct属性是自定义的属性，同时此属性在Repository中也是按照此方式进行存储的
    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);

    /**
     * todo：标准查询的方式有些不太适合，因为查询方式按照所规定的方式查,分词似乎不太准确
     * @param name
     * @param page
     * @return
     */
    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"name\" : \"?0\"}}}}")
    List<EsProduct> findBname(String name, Pageable page);  //可以直接在此设置分页

    /**
     *支持分词的模糊查询
     * @param name
     * @param pageable
     * @return
     */
    List<EsProduct> findByName(String name,Pageable pageable);

}
