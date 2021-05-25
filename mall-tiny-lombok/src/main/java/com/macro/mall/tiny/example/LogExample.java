package com.macro.mall.tiny.example;

import lombok.extern.java.Log;

/**
 * Created by macro on 2020/12/17.
 */
@Log
public class LogExample {
    public static void main(String[] args) {
        log.info("level info");
        log.warning("level warning");
        log.severe("level severe");
    }
}
