package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.DeviceInfo;

import java.util.List;

public interface DeviceInfoService {

    int insertDevices(List<DeviceInfo> list);

    int updateDevices(List<DeviceInfo> list);

    List<DeviceInfo> listDevices();
}
