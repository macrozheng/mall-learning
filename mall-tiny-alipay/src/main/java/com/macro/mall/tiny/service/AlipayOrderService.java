package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.AlipayOrder;

/**
 * @auther macrozheng
 * @description 支付宝订单管理Service
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
public interface AlipayOrderService {
    /**
     * 创建订单
     */
    AlipayOrder create();

    /**
     * 根据订单ID查询订单
     */
    AlipayOrder info(String orderId);
}
