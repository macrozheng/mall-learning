package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminMapper {
    long countByExample(UmsAdminExample example);

    int deleteByExample(UmsAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin row);

    int insertSelective(UmsAdmin row);

    List<UmsAdmin> selectByExample(UmsAdminExample example);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsAdmin row, @Param("example") UmsAdminExample example);

    int updateByExample(@Param("row") UmsAdmin row, @Param("example") UmsAdminExample example);

    int updateByPrimaryKeySelective(UmsAdmin row);

    int updateByPrimaryKey(UmsAdmin row);
}