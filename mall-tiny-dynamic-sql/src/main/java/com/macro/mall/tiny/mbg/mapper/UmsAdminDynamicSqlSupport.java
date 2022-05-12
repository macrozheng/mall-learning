package com.macro.mall.tiny.mbg.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UmsAdminDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UmsAdmin umsAdmin = new UmsAdmin();

    public static final SqlColumn<Long> id = umsAdmin.id;

    public static final SqlColumn<String> username = umsAdmin.username;

    public static final SqlColumn<String> password = umsAdmin.password;

    public static final SqlColumn<String> icon = umsAdmin.icon;

    public static final SqlColumn<String> email = umsAdmin.email;

    public static final SqlColumn<String> nickName = umsAdmin.nickName;

    public static final SqlColumn<String> note = umsAdmin.note;

    public static final SqlColumn<Date> createTime = umsAdmin.createTime;

    public static final SqlColumn<Date> loginTime = umsAdmin.loginTime;

    public static final SqlColumn<Integer> status = umsAdmin.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UmsAdmin extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<String> note = column("note", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> loginTime = column("login_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public UmsAdmin() {
            super("ums_admin");
        }
    }
}