package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.RackInfo;
import com.macro.mall.tiny.service.RackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/rack")
public class RackInfoController {
    @Autowired
    private RackInfoService rackInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listRack() {
        return CommonResult.success(rackInfoService.listRack());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insertRack(@RequestBody List<RackInfo> list) {
        return CommonResult.success(rackInfoService.insertRack(list));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult updateRack(@RequestBody List<RackInfo> list) {
        return CommonResult.success(rackInfoService.updateRack(list));
    }

}
