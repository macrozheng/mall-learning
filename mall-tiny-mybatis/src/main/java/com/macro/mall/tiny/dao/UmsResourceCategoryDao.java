package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.UmsResourceCategoryExt;
import org.springframework.stereotype.Repository;

/**
 * @auther macrozheng
 * @description 自定义UmsResourceCategory表查询
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@Repository
public interface UmsResourceCategoryDao {

    /**
     * 根据分类ID获取分类及对应资源
     */
    UmsResourceCategoryExt selectCategoryWithResource(Long id);
}
