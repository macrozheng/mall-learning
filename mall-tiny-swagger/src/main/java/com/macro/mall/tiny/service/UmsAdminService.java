package com.macro.mall.tiny.service;

import com.macro.mall.tiny.domain.AdminUserDetails;

/**
 * @auther macrozheng
 * @description 后台用于管理Service
 * @date 2020/10/15
 * @github https://github.com/macrozheng
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户信息
     */
    AdminUserDetails getAdminByUsername(String username);

    /**
     * 用户名密码登录
     */
    String login(String username, String password);
}
