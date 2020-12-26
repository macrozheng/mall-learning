package com.macro.mall.tiny.mbg.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsAdminRoleRelationDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsAdminRoleRelation umsAdminRoleRelation = new UmsAdminRoleRelation();

    public static final SqlColumn<Long> id = umsAdminRoleRelation.id;

    public static final SqlColumn<Long> adminId = umsAdminRoleRelation.adminId;

    public static final SqlColumn<Long> roleId = umsAdminRoleRelation.roleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsAdminRoleRelation extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> adminId = column("admin_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public UmsAdminRoleRelation() {
            super("ums_admin_role_relation");
        }
    }
}