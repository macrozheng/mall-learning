package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.DeviceInfo;
import com.macro.mall.tiny.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/device")
public class DeviceInfoController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listDevices() {
        return CommonResult.success(deviceInfoService.listDevices());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insertDevices(@RequestBody List<DeviceInfo> list) {
        return CommonResult.success(deviceInfoService.insertDevices(list));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateDevices(@RequestBody List<DeviceInfo> list) {
        return CommonResult.success(deviceInfoService.updateDevices(list));
    }
}
