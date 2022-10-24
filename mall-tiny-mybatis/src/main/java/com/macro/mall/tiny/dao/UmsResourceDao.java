package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.UmsResourceExt;
import com.macro.mall.tiny.model.UmsResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义UmsResource表查询
 * Created by macro on 2022/10/20.
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
