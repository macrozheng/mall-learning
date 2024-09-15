package com.macro.mall.tiny.example;

import lombok.Builder;
import lombok.ToString;

/**
 * @auther macrozheng
 * @description @Builder注解使用示例
 * @date 2020/12/17
 * @github https://github.com/macrozheng
 */
@Builder
@ToString
public class BuilderExample {
    private Long id;
    private String name;
    private Integer age;

    public static void main(String[] args) {
        BuilderExample example = BuilderExample.builder()
                .id(1L)
                .name("test")
                .age(20)
                .build();
        System.out.println(example);
    }
}
