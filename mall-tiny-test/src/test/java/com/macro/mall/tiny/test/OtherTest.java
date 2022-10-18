package com.macro.mall.tiny.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * JUnit其他测试
 * Created by macro on 2022/10/10.
 */
@ExtendWith(SpringExtension.class)
public class OtherTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleTest.class);
    private static int count = 0;

    @Test
    @Disabled("用于测试@Disabled注解")
    void disabledTest() {
        LOGGER.info("disabledTest()：方法被执行");
    }

    @RepeatedTest(3)
    void repeatedTest() {
        count++;
        LOGGER.info("repeatedTest()：重复执行第{}次",count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void parameterizedTest(int a){
        LOGGER.info("parameterizedTest()：a={}",a);
    }
}
