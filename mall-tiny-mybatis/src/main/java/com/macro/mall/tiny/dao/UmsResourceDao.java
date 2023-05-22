package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.UmsResourceExt;
import com.macro.mall.tiny.model.UmsResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther macrozheng
 * @description 自定义UmsResource表查询
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@Repository
public interface UmsResourceDao {
    /**
     * 根据资源ID获取资源及分类信息
     */
    UmsResourceExt selectResourceWithCategory(Long id);

    /**
     * 根据资源ID获取资源及分类信息
     */
    UmsResourceExt selectResourceWithCategory2(Long id);

    /**
     * 根据分类ID查询资源
     */
    List<UmsResource> selectListByCategoryId(Long categoryId);
}
