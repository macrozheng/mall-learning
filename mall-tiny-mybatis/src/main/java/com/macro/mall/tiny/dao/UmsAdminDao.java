package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther macrozheng
 * @description 自定义UmsAdmin表查询
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@Repository
public interface UmsAdminDao {

    /**
     * 根据ID查询用户
     */
    UmsAdmin selectByIdSimple(Long id);

    /**
     * 根据ID查询用户
     */
    UmsAdmin selectById(Long id);

    /**
     * 根据用户ID批量查询
     */
    List<UmsAdmin> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 插入用户
     */
    int insert(UmsAdmin entity);

    /**
     * 批量插入用户
     */
    int insertBatch(@Param("entityList") List<UmsAdmin> adminList);

    /**
     * 根据ID修改用户信息
     */
    int updateById(UmsAdmin entity);

    /**
     * 根据ID选择性修改用户信息
     */
    int updateByIdSelective(UmsAdmin entity);

    /**
     * 根据ID删除用户
     */
    int deleteById(Long id);

    /**
     * 根据用户名和Email模糊查询用户
     * 不输入查询所有
     */
    List<UmsAdmin> selectByUsernameAndEmailLike(@Param("username") String username,@Param("email") String email);

    /**
     * 根据用户名和Email模糊查询用户
     * 不输入不返回数据
     */
    List<UmsAdmin> selectByUsernameAndEmailLike2(@Param("username") String username,@Param("email") String email);

    /**
     * 根据用户名和Email模糊查询用户
     * 不输入查询所有
     */
    List<UmsAdmin> selectByUsernameAndEmailLike3(@Param("username") String username,@Param("email") String email);

}
