package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.AlipayOrder;
import com.macro.mall.tiny.mbg.model.AlipayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayOrderMapper {
    long countByExample(AlipayOrderExample example);

    int deleteByExample(AlipayOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlipayOrder row);

    int insertSelective(AlipayOrder row);

    List<AlipayOrder> selectByExample(AlipayOrderExample example);

    AlipayOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") AlipayOrder row, @Param("example") AlipayOrderExample example);

    int updateByExample(@Param("row") AlipayOrder row, @Param("example") AlipayOrderExample example);

    int updateByPrimaryKeySelective(AlipayOrder row);

    int updateByPrimaryKey(AlipayOrder row);
}