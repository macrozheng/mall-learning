package com.macro.mall.tiny.nosql.elasticsearch.document;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 搜索中的商品信息
 * Created by macro on 2018/6/19.
 * /标示映射到Elasticsearch文档上的领域对象
 *
 * todo:
 *  public @interface Document {
 * 	String indexName();             //索引库名次，mysql中【数据库】的概念
 * 	String type() default ""; *     //文档类型，mysql中【表】的概念【后面的只能有一个了】
 * 	short shards() default 5;       //默认分片数
 * 	short replicas() default 1;     //默认副本数量
 *  }
 *
 */

/**
 * http://localhost:9200/<index>/<type>/[<id>]。
 */
@ApiModel("el文件存贮类型")
@Document(indexName = "pms", type = "product",shards = 1,replicas = 0) //todo:文档可以认为是mysql中表行的概念
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id                         //todo：表示是文档的id，唯一标识，每一个id都表示不同的数据组（类似于表的主键）
    private Long id;
    /**
     * todo:
     *  @Field 【数据列名】
     *  public @interface Field {
     * 	FieldType type() default FieldType.Auto;         //文档中字段的类型
     * 	boolean index() default true;                    //是否建立倒排索引
     * 	boolean store() default false;                   //是否进行存储
     * 	String analyzer() default "";                    //分词器名次
     *  }
     */
    @Field(type = FieldType.Keyword)
    private String productSn;
    private Long brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    private Long productCategoryId;
    @Field(type = FieldType.Keyword)
    private String productCategoryName;
    private String pic;
    /**
     * ·@Field默认是可以不加的，默认所有属性都会添加到ES中。加上@Field之后，@document默认把所有字段加上索引失效，只有@Field 才会被索引(同时也看设置索引的属性是否为no)
     *
     * ·@Field默认分词
     * ·@Field(type = FieldType.Keyword) 全文检索，一字不少
     * ·@Field(analyzer = "ik_max_word",type = FieldType.Text) 分词检索
     */
    // 不需要中文分词的字段设置成@Field(type = FieldType.Keyword)类型，
    // 需要中文分词的设置成@Field(analyzer = "ik_max_word",type = FieldType.Text)类型。

    //　keyword：会被当做一个词条，不会再进行分词。可以被用来检索过滤、排序和聚合。keyword 类型字段只能用本身来进行检索。
    //　text：可以进行分词，可以用来索引长文本，将文本分析后进行分词并给分词后的词条建立索引，text 数据类型不能用来排序和聚合
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;
    private BigDecimal price;
    private Integer sale;
    private Integer newStatus;
    private Integer recommandStatus;
    private Integer stock;
    private Integer promotionType;
    private Integer sort;
    @Field(type =FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<EsProductAttributeValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<EsProductAttributeValue> attrValueList) {
        this.attrValueList = attrValueList;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
