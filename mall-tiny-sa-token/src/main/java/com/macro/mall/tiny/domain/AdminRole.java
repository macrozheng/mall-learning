package com.macro.mall.tiny.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户相关角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class AdminRole {
    private Long id;
    private String name;
    private List<String> permissionList;
}
