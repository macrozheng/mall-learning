package com.macro.mall.tiny.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by macro on 2020/12/17.
 */
@Getter
@Setter
@EqualsAndHashCode
public class EqualsAndHashCodeExample {
    private Long id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private Integer age;

    public static void main(String[] args) {
        EqualsAndHashCodeExample example1 = new EqualsAndHashCodeExample();
        example1.setId(1L);
        example1.setName("test");
        example1.setAge(20);
        EqualsAndHashCodeExample example2 = new EqualsAndHashCodeExample();
        example2.setId(1L);
        //equals方法只对比id，返回true
        System.out.println(example1.equals(example2));
    }
}
