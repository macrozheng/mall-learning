package com.macro.mall.tiny.example;

import lombok.NonNull;

/**
 * @auther macrozheng
 * @description @NonNull注解使用示例
 * @date 2020/12/16
 * @github https://github.com/macrozheng
 */
public class NonNullExample {
    private String name;
    public  NonNullExample(@NonNull String name){
        this.name = name;
    }

    public static void main(String[] args) {
        new NonNullExample("test");
        //会抛出NullPointerException
        new NonNullExample(null);
    }
}
