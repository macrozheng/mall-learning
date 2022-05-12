package com.macro.mall.tiny.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录用户
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class AdminUser {
    private Long id;
    private String username;
    private String password;
    private Long roleId;
    private AdminRole role;
}
