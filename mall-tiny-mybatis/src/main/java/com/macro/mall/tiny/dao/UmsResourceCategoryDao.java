package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.UmsResourceCategoryExt;
import org.springframework.stereotype.Repository;

/**
 * 自定义UmsResourceCategory表查询
 * Created by macro on 2022/10/20.
 */
@Repository
public interface UmsResourceCategoryDao {

    /**
     * 根据分类ID获取分类及对应资源
     */
    UmsResourceCategoryExt selectCategoryWithResource(Long id);
}
