package com.macro.mall.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 订单Dto
 * Created by macro on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDto {
    private Long id;
    private String orderSn;
    private Date createTime;
    private String receiverAddress;
    //子对象映射Dto
    private MemberDto memberDto;
    //子对象数组映射Dto
    private List<ProductDto> productDtoList;
}
