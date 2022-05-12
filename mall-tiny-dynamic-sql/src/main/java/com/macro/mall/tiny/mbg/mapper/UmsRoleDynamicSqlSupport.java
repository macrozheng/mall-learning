package com.macro.mall.tiny.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsRoleDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsRole umsRole = new UmsRole();

    public static final SqlColumn<Long> id = umsRole.id;

    public static final SqlColumn<String> name = umsRole.name;

    public static final SqlColumn<String> description = umsRole.description;

    public static final SqlColumn<Integer> adminCount = umsRole.adminCount;

    public static final SqlColumn<Date> createTime = umsRole.createTime;

    public static final SqlColumn<Integer> status = umsRole.status;

    public static final SqlColumn<Integer> sort = umsRole.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsRole extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> adminCount = column("admin_count", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public UmsRole() {
            super("ums_role");
        }
    }
}