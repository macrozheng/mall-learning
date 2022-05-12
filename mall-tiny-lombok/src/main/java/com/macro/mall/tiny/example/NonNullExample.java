package com.macro.mall.tiny.example;

import lombok.NonNull;

/**
 * Created by macro on 2020/12/16.
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
