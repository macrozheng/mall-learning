package com.macro.mall.tiny.service;


import com.macro.mall.tiny.dto.UmsMenuNode;

import java.util.List;

/**
 * @auther macrozheng
 * @description 后台用户权限管理Service
 * @date 2018/9/29
 * @github https://github.com/macrozheng
 */
public interface UmsMenuService {

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();
}
