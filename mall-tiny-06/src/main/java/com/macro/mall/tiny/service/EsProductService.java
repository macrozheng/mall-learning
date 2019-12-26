package com.macro.mall.tiny.service;

import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品搜索管理Service
 * Created by macro on 2018/6/19.
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 查询所有记录
     */
    List<EsProduct> findAll();

    /**
     * 模板查询和标准查询语句
     */
    List<EsProduct> search2(String name, String subtitle);

    /**
     * 使用@Query注解可以用Elasticsearch的DSL语句进行查询
     */
    List<EsProduct> queryName(String name, String subtitle, Pageable page);

    /**
     * 标准查询
     */
    List<EsProduct> findByName(String name, Pageable page);
}
