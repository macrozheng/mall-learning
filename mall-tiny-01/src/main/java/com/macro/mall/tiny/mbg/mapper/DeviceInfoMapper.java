package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.DeviceInfo;
import com.macro.mall.tiny.mbg.model.DeviceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceInfoMapper {
    int countByExample(DeviceInfoExample example);

    int deleteByExample(DeviceInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceInfo record);

    int insertSelective(DeviceInfo record);

    List<DeviceInfo> selectByExample(DeviceInfoExample example);

    DeviceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceInfo record, @Param("example") DeviceInfoExample example);

    int updateByExample(@Param("record") DeviceInfo record, @Param("example") DeviceInfoExample example);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);

    int insertDevices(List<DeviceInfo> list);

    int updateDevices(List<DeviceInfo> list);

    List<DeviceInfo> listDevices();

}