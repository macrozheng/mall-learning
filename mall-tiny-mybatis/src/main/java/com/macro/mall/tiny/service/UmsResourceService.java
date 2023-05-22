package com.macro.mall.tiny.service;

import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.model.UmsResource;

/**
 * @auther macrozheng
 * @description UmsResource的Service接口
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
public interface UmsResourceService {

    PageInfo<UmsResource> page(Integer pageNum, Integer pageSize,Long categoryId);
}
