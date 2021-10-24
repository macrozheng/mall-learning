package com.macro.mall.tiny.exception;

/**
 * 商品验证异常类
 * Created by macro on 2021/10/22.
 */
public class ProductValidatorException extends Exception{
    public ProductValidatorException(String message) {
        super(message);
    }
}
