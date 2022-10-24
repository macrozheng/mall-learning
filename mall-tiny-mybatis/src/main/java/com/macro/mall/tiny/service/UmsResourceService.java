package com.macro.mall.tiny.service;

import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.model.UmsResource;

/**
 * UmsResource的Service接口
 * Created by macro on 2022/10/20.
 */
public interface UmsResourceService {

    PageInfo<UmsResource> page(Integer pageNum, Integer pageSize,Long categoryId);
}
