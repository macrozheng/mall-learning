package com.macro.mall.tiny.validator;

import com.macro.mall.tiny.exception.ProductValidatorException;

import java.math.BigDecimal;

/**
 * 商品验证异常处理器
 * Created by macro on 2021/10/22.
 */
public class ProductValidator {
    public BigDecimal validatePrice(BigDecimal price) throws ProductValidatorException {
        if(price.compareTo(BigDecimal.ZERO)<0){
            throw new ProductValidatorException("价格不能小于0！");
        }
        return price;
    }
}
