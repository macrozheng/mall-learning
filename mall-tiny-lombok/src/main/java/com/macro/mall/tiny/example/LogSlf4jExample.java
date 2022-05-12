package com.macro.mall.tiny.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by macro on 2020/12/17.
 */
@Slf4j
public class LogSlf4jExample {
    public static void main(String[] args) {
        log.info("level:{}","info");
        log.warn("level:{}","warn");
        log.error("level:{}", "error");
    }
}
