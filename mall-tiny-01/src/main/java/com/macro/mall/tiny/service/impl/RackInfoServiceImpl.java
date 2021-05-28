package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.RackInfoMapper;
import com.macro.mall.tiny.mbg.model.RackInfo;
import com.macro.mall.tiny.service.RackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackInfoServiceImpl implements RackInfoService {
    @Autowired
    private RackInfoMapper rackInfoMapper;

    @Override
    public int updateRack(List<RackInfo> list) {
        return rackInfoMapper.updateRacks(list);
    }

    @Override
    public int insertRack(List<RackInfo> list) {
        return rackInfoMapper.insertRacks(list);
    }

    @Override
    public List<RackInfo> listRack() {
        return rackInfoMapper.listRacks();
    }

}
