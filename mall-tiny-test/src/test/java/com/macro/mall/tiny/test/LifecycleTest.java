package com.macro.mall.tiny.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * JUnit生命周期测试
 * Created by macro on 2022/10/10.
 */
@ExtendWith(SpringExtension.class)
public class LifecycleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleTest.class);

    @BeforeAll
    static void allInit(){
        LOGGER.info("allInit()：在所有方法前执行，只执行一次");
    }

    @BeforeEach
    void eachInit(){
        LOGGER.info("eachInit()：在测试方法前执行，每个测试方法前都执行");
    }

    @Test
    void successTest() {
        LOGGER.info("successTest()：方法执行成功");
    }

    @AfterEach
    void eachDown(){
        LOGGER.info("eachDown()：在测试方法后执行，每个测试方法后都执行");
    }

    @AfterAll
    static void allDown(){
        LOGGER.info("allDown()：在测试方法后执行，每个测试方法后都执行");
    }

}
