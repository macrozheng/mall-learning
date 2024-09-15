package com.macro.mall.tiny.example;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther macrozheng
 * @description @Slf4j注解使用示例
 * @date 2020/12/17
 * @github https://github.com/macrozheng
 */
@Slf4j
public class LogSlf4jExample {
    public static void main(String[] args) {
        log.info("level:{}","info");
        log.warn("level:{}","warn");
        log.error("level:{}", "error");
    }
}
