package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.domain.AdminRoleDto;
import com.macro.mall.tiny.domain.RoleStatDto;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * Created by macro on 2020/12/9.
 */
public interface UmsAdminDao {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "RoleStatResult", value = {
            @Result(column = "roleId", property = "roleId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "roleName", property = "roleName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "count", property = "count", jdbcType = JdbcType.INTEGER)
    })
    List<RoleStatDto> groupList(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("AdminRoleResult")
    AdminRoleDto selectWithRoleList(SelectStatementProvider selectStatement);
}
