package com.macro.mall.tiny.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * JUnit指定方法测试顺序
 * Created by macro on 2022/10/10.
 */
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodOrderTest.class);

    @Test
    @Order(1)
    @DisplayName("order为1的方法")
    void lowOrder(){
        LOGGER.info("lowOrder method");
    }

    @Test
    @Order(10)
    @DisplayName("order为10的方法")
    void highOrder(){
        LOGGER.info("highOrder method");
    }
}
