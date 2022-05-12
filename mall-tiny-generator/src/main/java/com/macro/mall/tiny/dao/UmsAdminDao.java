package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.AdminRoleDto;
import com.macro.mall.tiny.domain.ResourceWithCateDto;
import com.macro.mall.tiny.domain.RoleStatDto;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by macro on 2020/12/9.
 */
public interface UmsAdminDao {

    List<RoleStatDto> groupList();

    AdminRoleDto selectWithRoleList(@Param("id") Long id);

    List<UmsAdmin> subList(@Param("roleId") Long roleId);

    ResourceWithCateDto selectResourceWithCate(@Param("id")Long id);
}
