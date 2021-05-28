package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.RackInfo;
import com.macro.mall.tiny.mbg.model.RackInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RackInfoMapper {

    int updateRacks(List<RackInfo> list);

    int insertRacks(List<RackInfo> list);

    List<RackInfo> listRacks();
}