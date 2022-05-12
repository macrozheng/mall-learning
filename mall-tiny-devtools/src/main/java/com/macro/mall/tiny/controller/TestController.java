package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macro on 2021/3/25.
 */
@Api(tags = "TestController", description = "SpringBoot Dev Tools测试")
@Controller
@RequestMapping("/test")
public class TestController {

    @ApiOperation("测试修改")
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult first() {
        String message = "返回消息";
        return CommonResult.success(null,message);
    }
}
