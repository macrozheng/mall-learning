package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by macro on 2021/3/25.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult first() {
        String message = "返回消息";
        return CommonResult.success(null,message);
    }
}
