package com.macro.mall.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员商品信息组合Dto
 * Created by macro on 2021/10/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberOrderDto extends MemberDto{
    private String orderSn;
    private String receiverAddress;
}
