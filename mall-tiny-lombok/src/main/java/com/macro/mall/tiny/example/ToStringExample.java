package com.macro.mall.tiny.example;

import lombok.ToString;

/**
 * @auther macrozheng
 * @description @ToString注解使用示例
 * @date 2020/12/17
 * @github https://github.com/macrozheng
 */
@ToString
public class ToStringExample {
    @ToString.Exclude
    private Long id;
    private String name;
    private Integer age;
    public ToStringExample(Long id,String name,Integer age){
        this.id =id;
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ToStringExample example = new ToStringExample(1L,"test",20);
        //自动实现toString方法，输出ToStringExample(name=test, age=20)
        System.out.println(example);
    }
}
