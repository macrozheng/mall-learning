package com.macro.mall.tiny.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.macro.mall.tiny.domain.AdminRole;
import com.macro.mall.tiny.domain.AdminUser;
import com.macro.mall.tiny.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by macro on 2020/10/15.
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    /**
     * 存放用户信息
     */
    private final List<AdminUser> adminUserList = new ArrayList<>();
    /**
     * 存储角色信息
     */
    private final List<AdminRole> adminRoleList = new ArrayList<>();

    @PostConstruct
    private void init() {
        adminRoleList.add(AdminRole.builder()
                .id(1L)
                .name("ROLE_ADMIN")
                .permissionList(Arrays.asList("brand:create", "brand:read", "brand:update", "brand:delete"))
                .build());
        adminRoleList.add(AdminRole.builder()
                .id(2L)
                .name("ROLE_USER")
                .permissionList(Collections.singletonList("brand:read"))
                .build());
        adminUserList.add(AdminUser.builder()
                .id(1L)
                .username("admin")
                .password(SaSecureUtil.md5("123456"))
                .roleId(1L)
                .build());
        adminUserList.add(AdminUser.builder()
                .id(2L)
                .username("macro")
                .password(SaSecureUtil.md5("123456"))
                .roleId(2L)
                .build());
    }

    @Override
    public AdminUser getAdminByUsername(String username) {
        List<AdminUser> findList = adminUserList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(findList)) {
            return findList.get(0);
        }
        return null;
    }

    @Override
    public AdminUser getAdminById(Long id) {
        List<AdminUser> findList = adminUserList.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(findList)) {
            AdminUser findUser = findList.get(0);
            List<AdminRole> findRoleList = adminRoleList.stream().filter(item -> item.getId().equals(findUser.getRoleId())).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(findRoleList)) {
                findUser.setRole(findRoleList.get(0));
            }
            return findUser;
        }
        return null;
    }

    @Override
    public SaTokenInfo login(String username, String password) {
        SaTokenInfo saTokenInfo = null;
        AdminUser adminUser = getAdminByUsername(username);
        if (adminUser == null) {
            return null;
        }
        if (!SaSecureUtil.md5(password).equals(adminUser.getPassword())) {
            return null;
        }
        // 密码校验成功后登录，一行代码实现登录
        StpUtil.login(adminUser.getId());
        // 获取当前登录用户Token信息
        saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }
}
