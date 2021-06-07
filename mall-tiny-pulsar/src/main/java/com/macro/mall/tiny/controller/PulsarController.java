package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.component.PulsarProducer;
import com.macro.mall.tiny.dto.MessageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Pulsar功能测试
 * Created by macro on 2021/5/19.
 */
@Api(tags = "PulsarController", description = "Pulsar功能测试")
@Controller
@RequestMapping("/pulsar")
public class PulsarController {

    @Autowired
    private PulsarProducer pulsarProducer;

    @ApiOperation("发送消息")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult sendMessage(@RequestBody MessageDto message) {
        pulsarProducer.send(message);
        return CommonResult.success(null);
    }
}
