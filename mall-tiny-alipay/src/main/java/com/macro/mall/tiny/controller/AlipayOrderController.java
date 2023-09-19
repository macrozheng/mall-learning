package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.AlipayOrder;
import com.macro.mall.tiny.service.AlipayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther macrozheng
 * @description 支付宝订单管理Controller
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
@Controller
@Api(tags = "AlipayOrderController")
@Tag(name = "AlipayOrderController", description = "支付宝订单管理")
@RequestMapping("/alipayOrder")
public class AlipayOrderController {

    @Autowired
    private AlipayOrderService alipayOrderService;

    @ApiOperation("创建订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AlipayOrder> create() {
        AlipayOrder order = alipayOrderService.create();
        return CommonResult.success(order);
    }

    @ApiOperation("查询订单")
    @RequestMapping(value = "/info/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AlipayOrder> info(@PathVariable String orderId) {
        AlipayOrder order = alipayOrderService.info(orderId);
        return CommonResult.success(order);
    }
}
