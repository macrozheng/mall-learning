package com.macro.mall.tiny.example;

import lombok.Value;

/**
 * @auther macrozheng
 * @description @Value注解使用示例
 * @date 2020/12/17
 * @github https://github.com/macrozheng
 */
@Value
public class ValueExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        //只能使用全参构造器
        ValueExample example = new ValueExample(1L,"test",20);
        // example.setName("andy") //没有生成setter方法，会报错
        // example.name="andy" //字段被设置为final类型，会报错
    }
}
