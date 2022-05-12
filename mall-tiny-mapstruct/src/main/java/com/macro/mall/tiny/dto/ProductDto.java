package com.macro.mall.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品Dto
 * Created by macro on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDto {
    //使用常量
    private Long id;
    //使用表达式生成属性
    private String productSn;
    private String name;
    private String subTitle;
    private String brandName;
    private BigDecimal price;
    //使用默认值
    private Integer count;
    private Date createTime;
}
