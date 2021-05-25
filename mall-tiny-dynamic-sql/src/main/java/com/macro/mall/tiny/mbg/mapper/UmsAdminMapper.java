package com.macro.mall.tiny.mbg.mapper;

import static com.macro.mall.tiny.mbg.mapper.UmsAdminDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UmsAdminMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, password, icon, email, nickName, note, createTime, loginTime, status);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<UmsAdmin> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UmsAdminResult")
    Optional<UmsAdmin> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UmsAdminResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<UmsAdmin> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UmsAdmin record) {
        return MyBatis3Utils.insert(this::insert, record, umsAdmin, c ->
            c.map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(icon).toProperty("icon")
            .map(email).toProperty("email")
            .map(nickName).toProperty("nickName")
            .map(note).toProperty("note")
            .map(createTime).toProperty("createTime")
            .map(loginTime).toProperty("loginTime")
            .map(status).toProperty("status")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UmsAdmin record) {
        return MyBatis3Utils.insert(this::insert, record, umsAdmin, c ->
            c.map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(nickName).toPropertyWhenPresent("nickName", record::getNickName)
            .map(note).toPropertyWhenPresent("note", record::getNote)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(loginTime).toPropertyWhenPresent("loginTime", record::getLoginTime)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsAdmin> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsAdmin> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UmsAdmin> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UmsAdmin> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, umsAdmin, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UmsAdmin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(icon).equalTo(record::getIcon)
                .set(email).equalTo(record::getEmail)
                .set(nickName).equalTo(record::getNickName)
                .set(note).equalTo(record::getNote)
                .set(createTime).equalTo(record::getCreateTime)
                .set(loginTime).equalTo(record::getLoginTime)
                .set(status).equalTo(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UmsAdmin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(nickName).equalToWhenPresent(record::getNickName)
                .set(note).equalToWhenPresent(record::getNote)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(loginTime).equalToWhenPresent(record::getLoginTime)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UmsAdmin record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(icon).equalTo(record::getIcon)
            .set(email).equalTo(record::getEmail)
            .set(nickName).equalTo(record::getNickName)
            .set(note).equalTo(record::getNote)
            .set(createTime).equalTo(record::getCreateTime)
            .set(loginTime).equalTo(record::getLoginTime)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UmsAdmin record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(nickName).equalToWhenPresent(record::getNickName)
            .set(note).equalToWhenPresent(record::getNote)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(loginTime).equalToWhenPresent(record::getLoginTime)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}