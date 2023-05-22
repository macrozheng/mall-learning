package com.macro.mall.tiny.example;

import lombok.extern.java.Log;

/**
 * @auther macrozheng
 * @description @Log注解使用示例
 * @date 2020/12/17
 * @github https://github.com/macrozheng
 */
@Log
public class LogExample {
    public static void main(String[] args) {
        log.info("level info");
        log.warning("level warning");
        log.severe("level severe");
    }
}
