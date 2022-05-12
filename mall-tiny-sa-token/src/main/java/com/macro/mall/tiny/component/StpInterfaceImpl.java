package com.macro.mall.tiny.component;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.convert.Convert;
import com.macro.mall.tiny.domain.AdminUser;
import com.macro.mall.tiny.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private UmsAdminService adminService;
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        AdminUser adminUser = adminService.getAdminById(Convert.toLong(loginId));
        return adminUser.getRole().getPermissionList();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        AdminUser adminUser = adminService.getAdminById(Convert.toLong(loginId));
        return Collections.singletonList(adminUser.getRole().getName());
    }
}
