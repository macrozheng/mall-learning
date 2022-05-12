package com.macro.mall.tiny.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.macro.mall.tiny.domain.AdminUser;

/**
 * 后台用于管理Service
 * Created by macro on 2020/10/15.
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户信息
     */
    AdminUser getAdminByUsername(String username);

    /**
     * 根据用户ID获取用户
     */
    AdminUser getAdminById(Long id);

    /**
     * 用户名密码登录
     */
    SaTokenInfo login(String username, String password);
}
