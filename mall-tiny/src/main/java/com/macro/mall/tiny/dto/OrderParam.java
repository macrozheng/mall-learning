package com.macro.mall.tiny.dto;

import lombok.Data;

/**
 * @auther macrozheng
 * @description 生成订单时传入的参数
 * @date 2018/8/30
 * @github https://github.com/macrozheng
 */
@Data
public class OrderParam {
    //收货地址id
    private Long memberReceiveAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分数
    private Integer useIntegration;
    //支付方式
    private Integer payType;
}
