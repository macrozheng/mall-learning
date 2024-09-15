package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther macrozheng
 * @description 搜索系统中的商品管理自定义Dao
 * @date 2018/6/19
 * @github https://github.com/macrozheng
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
