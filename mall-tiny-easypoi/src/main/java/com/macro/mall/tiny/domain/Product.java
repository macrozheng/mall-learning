package com.macro.mall.tiny.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 商品
 * Created by macro on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product {
    @Excel(name = "ID", width = 10)
    private Long id;
    @Excel(name = "商品SN", width = 20)
    private String productSn;
    @Excel(name = "商品名称", width = 20)
    private String name;
    @Excel(name = "商品副标题", width = 30)
    private String subTitle;
    @Excel(name = "品牌名称", width = 20)
    private String brandName;
    @Excel(name = "商品价格", width = 10)
    private BigDecimal price;
    @Excel(name = "购买数量", width = 10, suffix = "件")
    private Integer count;
}
