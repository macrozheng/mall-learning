package com.macro.mall.tiny.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dao.UmsAdminDao;
import com.macro.mall.tiny.domain.AdminRoleDto;
import com.macro.mall.tiny.domain.RoleStatDto;
import com.macro.mall.tiny.mbg.mapper.*;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.service.UmsAdminService;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * 后台用户管理Service实现类
 * Created by macro on 2020/12/8.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminDao adminDao;

    @Override
    public void create(UmsAdmin entity) {
        adminMapper.insert(entity);
    }

    @Override
    public void update(UmsAdmin entity) {
        adminMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void delete(Long id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UmsAdmin select(Long id) {
        Optional<UmsAdmin> optionalEntity = adminMapper.selectByPrimaryKey(id);
        return optionalEntity.orElse(null);
    }

    @Override
    public List<UmsAdmin> listAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.select(SelectDSLCompleter.allRows());
    }

    @Override
    public List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList) {
        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider selectStatement = SqlBuilder.select(UmsAdminMapper.selectList)
                .from(UmsAdminDynamicSqlSupport.umsAdmin)
                .where(UmsAdminDynamicSqlSupport.username, isEqualToWhenPresent(username))
                .and(UmsAdminDynamicSqlSupport.status, isIn(statusList))
                .orderBy(UmsAdminDynamicSqlSupport.createTime.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return adminMapper.selectMany(selectStatement);
    }

    @Override
    public List<UmsAdmin> lambdaList(Integer pageNum, Integer pageSize, String username, List<Integer> statusList) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> list = adminMapper.select(c -> c.where(UmsAdminDynamicSqlSupport.username, isEqualToWhenPresent(username))
                .and(UmsAdminDynamicSqlSupport.status, isIn(statusList))
                .orderBy(UmsAdminDynamicSqlSupport.createTime.descending()));
        return list;
    }

    @Override
    public List<UmsAdmin> subList(Long roleId) {
        SelectStatementProvider selectStatement = SqlBuilder.select(UmsAdminMapper.selectList)
                .from(UmsAdminDynamicSqlSupport.umsAdmin)
                .where(UmsAdminDynamicSqlSupport.id, isIn(SqlBuilder.select(UmsAdminRoleRelationDynamicSqlSupport.adminId)
                        .from(UmsAdminRoleRelationDynamicSqlSupport.umsAdminRoleRelation)
                        .where(UmsAdminRoleRelationDynamicSqlSupport.roleId, isEqualTo(roleId))))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return adminMapper.selectMany(selectStatement);
    }

    @Override
    public List<RoleStatDto> groupList() {
        SelectStatementProvider selectStatement = SqlBuilder.select(UmsRoleDynamicSqlSupport.id.as("roleId"), UmsRoleDynamicSqlSupport.name.as("roleName"), count(UmsAdminDynamicSqlSupport.id).as("count"))
                .from(UmsRoleDynamicSqlSupport.umsRole)
                .leftJoin(UmsAdminRoleRelationDynamicSqlSupport.umsAdminRoleRelation)
                .on(UmsRoleDynamicSqlSupport.id, equalTo(UmsAdminRoleRelationDynamicSqlSupport.roleId))
                .leftJoin(UmsAdminDynamicSqlSupport.umsAdmin)
                .on(UmsAdminRoleRelationDynamicSqlSupport.adminId, equalTo(UmsAdminDynamicSqlSupport.id))
                .groupBy(UmsRoleDynamicSqlSupport.id)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return adminDao.groupList(selectStatement);
    }

    @Override
    public void deleteByUsername(String username) {
        DeleteStatementProvider deleteStatement = SqlBuilder.deleteFrom(UmsAdminDynamicSqlSupport.umsAdmin)
                .where(UmsAdminDynamicSqlSupport.username, isEqualTo(username))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        adminMapper.delete(deleteStatement);
    }

    @Override
    public void updateByIds(List<Long> ids, Integer status) {
        UpdateStatementProvider updateStatement = SqlBuilder.update(UmsAdminDynamicSqlSupport.umsAdmin)
                .set(UmsAdminDynamicSqlSupport.status).equalTo(status)
                .where(UmsAdminDynamicSqlSupport.id, isIn(ids))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        adminMapper.update(updateStatement);
    }

    @Override
    public AdminRoleDto selectWithRoleList(Long id) {
        List<BasicColumn> columnList = new ArrayList<>(CollUtil.toList(UmsAdminMapper.selectList));
        columnList.add(UmsRoleDynamicSqlSupport.id.as("role_id"));
        columnList.add(UmsRoleDynamicSqlSupport.name.as("role_name"));
        columnList.add(UmsRoleDynamicSqlSupport.description.as("role_description"));
        columnList.add(UmsRoleDynamicSqlSupport.createTime.as("role_create_time"));
        columnList.add(UmsRoleDynamicSqlSupport.status.as("role_status"));
        columnList.add(UmsRoleDynamicSqlSupport.sort.as("role_sort"));
        SelectStatementProvider selectStatement = SqlBuilder.select(columnList)
                .from(UmsAdminDynamicSqlSupport.umsAdmin)
                .leftJoin(UmsAdminRoleRelationDynamicSqlSupport.umsAdminRoleRelation)
                .on(UmsAdminDynamicSqlSupport.id, equalTo(UmsAdminRoleRelationDynamicSqlSupport.adminId))
                .leftJoin(UmsRoleDynamicSqlSupport.umsRole)
                .on(UmsAdminRoleRelationDynamicSqlSupport.roleId, equalTo(UmsRoleDynamicSqlSupport.id))
                .where(UmsAdminDynamicSqlSupport.id, isEqualTo(id))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return adminDao.selectWithRoleList(selectStatement);
    }
}
