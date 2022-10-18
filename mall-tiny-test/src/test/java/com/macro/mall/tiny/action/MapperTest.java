package com.macro.mall.tiny.action;

import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Dao层方法测试
 * Created by macro on 2022/10/11.
 */
@SpringBootTest
public class MapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperTest.class);

    @Autowired
    private PmsBrandMapper brandMapper;

    @Test
    void testGetById(){
        long id = 6;
        PmsBrand pmsBrand = brandMapper.selectByPrimaryKey(id);
        LOGGER.info("brand name:{}",pmsBrand.getName());
        Assertions.assertEquals("小米",pmsBrand.getName());
    }
}
