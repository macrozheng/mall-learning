package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.RackInfo;

import java.util.List;

public interface RackInfoService {
    int updateRack(List<RackInfo> list);

    int insertRack(List<RackInfo> list);

    List<RackInfo> listRack();
}
