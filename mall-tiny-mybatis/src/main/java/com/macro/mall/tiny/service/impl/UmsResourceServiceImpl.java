package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.dao.UmsResourceDao;
import com.macro.mall.tiny.model.UmsResource;
import com.macro.mall.tiny.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UmsResource的Service接口实现类
 * Created by macro on 2022/10/20.
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private UmsResourceDao umsResourceDao;

    @Override
    public PageInfo<UmsResource> page(Integer pageNum, Integer pageSize,Long categoryId) {
        PageHelper.startPage(pageNum,pageSize);
        List<UmsResource> resourceList = umsResourceDao.selectListByCategoryId(categoryId);
        PageInfo<UmsResource> pageInfo = new PageInfo<>(resourceList);
        return pageInfo;
    }
}
