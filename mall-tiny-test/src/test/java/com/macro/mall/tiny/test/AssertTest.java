package com.macro.mall.tiny.test;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

/**
 * JUnit断言测试
 * Created by macro on 2022/10/11.
 */
@ExtendWith(SpringExtension.class)
public class AssertTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleTest.class);

    @Test
    void failTest() {
        Assertions.fail("failTest()：方法执行失败");
    }

    @Test
    void trueTest(){
        Assertions.assertTrue(1==1);
    }

    @Test
    void trueFalse(){
        Assertions.assertFalse(3<=2);
    }

    @Test
    void nullTest(){
        String str = null;
        Assertions.assertNull(str);
    }

    @Test
    void notNullTest(){
        String str = "test";
        Assertions.assertNotNull(str);
    }

    @Test
    void equalsTest(){
        String str1 = "test";
        String str2 = "test";
        Assertions.assertEquals(str1,str2);
    }

    @Test
    void notEqualsTest(){
        String str1 = "test";
        String str2 = "test";
        Assertions.assertNotEquals(str1,str2);
    }

    @Test
    void throwsTest(){
        Assertions.assertThrows(NullPointerException.class,()->{
            String str = null;
            LOGGER.info(str.toLowerCase());
        });
    }

    @Test
    void timeoutTest(){
        Assertions.assertTimeout(Duration.ofMillis(1000),()->{
            long sleepTime = 2000;
            ThreadUtil.sleep(sleepTime);
            LOGGER.info("timeoutTest():休眠{}毫秒",sleepTime);
        });
    }

    @Test
    void assertAllTest(){
        Assertions.assertAll(()->{
            trueTest();
        },()->{
            nullTest();
        },()->{
            equalsTest();
        });
    }

}
