package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.component.KafkaProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Kafka功能测试
 * Created by macro on 2021/5/19.
 */
@Api(tags = "KafkaController", description = "Kafka功能测试")
@Controller
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @ApiOperation("发送消息")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult sendMessage(@RequestParam String message) {
        kafkaProducer.send(message);
        return CommonResult.success(null);
    }
}
