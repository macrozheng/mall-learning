package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.DeviceInfoMapper;
import com.macro.mall.tiny.mbg.model.DeviceInfo;
import com.macro.mall.tiny.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public int insertDevices(List<DeviceInfo> list) {
        return deviceInfoMapper.insertDevices(list);
    }

    @Override
    public int updateDevices(List<DeviceInfo> list) {
        return deviceInfoMapper.updateDevices(list);
    }

    @Override
    public List<DeviceInfo> listDevices() {
        return deviceInfoMapper.listDevices();
    }
}
