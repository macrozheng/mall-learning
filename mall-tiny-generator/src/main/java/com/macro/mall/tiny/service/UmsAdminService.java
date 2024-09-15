package com.macro.mall.tiny.service;

import com.macro.mall.tiny.domain.AdminRoleDto;
import com.macro.mall.tiny.domain.ResourceWithCateDto;
import com.macro.mall.tiny.domain.RoleStatDto;
import com.macro.mall.tiny.mbg.model.UmsAdmin;

import java.util.List;

/**
 * @auther macrozheng
 * @description 后台用户管理Service
 * @date 2020/12/8
 * @github https://github.com/macrozheng
 */
public interface UmsAdminService {
    void create(UmsAdmin entity);

    void update(UmsAdmin entity);

    void delete(Long id);

    UmsAdmin select(Long id);

    List<UmsAdmin> listAll(Integer pageNum, Integer pageSize);

    List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList);

    List<UmsAdmin> subList(Long roleId);

    List<RoleStatDto> groupList();

    void deleteByUsername(String username);

    void updateByIds(List<Long> ids,Integer status);

    AdminRoleDto selectWithRoleList(Long id);

    ResourceWithCateDto selectResourceWithCate(Long id);
}
