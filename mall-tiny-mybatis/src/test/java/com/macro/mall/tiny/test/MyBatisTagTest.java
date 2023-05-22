package com.macro.mall.tiny.test;

import cn.hutool.core.util.RandomUtil;
import com.macro.mall.tiny.dao.UmsAdminDao;
import com.macro.mall.tiny.model.UmsAdmin;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther macrozheng
 * @description MyBatis标签测试
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@SpringBootTest
public class MyBatisTagTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisTagTest.class);

    @Autowired
    private UmsAdminDao umsAdminDao;

    @Test
    void testIf(){
        List<UmsAdmin> userList = umsAdminDao.selectByUsernameAndEmailLike("test","test");
        LOGGER.info("testIf result={}",userList);
    }

    @Test
    void testChoose(){
        List<UmsAdmin> userList = umsAdminDao.selectByUsernameAndEmailLike2(null,null);
        LOGGER.info("testChoose result={}",userList);
    }

    @Test
    void testWhere(){
        List<UmsAdmin> userList = umsAdminDao.selectByUsernameAndEmailLike3("test","test");
        LOGGER.info("testWhere result={}",userList);
    }

    @Test
    void testSet(){
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setId(1L);
        umsAdmin.setUsername("test");
        umsAdmin.setNickName("new test");
        int result = umsAdminDao.updateByIdSelective(umsAdmin);
        LOGGER.info("testSet result={}",result);
    }

    @Test
    void testForeach(){
        List<UmsAdmin> adminList = new ArrayList<>();
        adminList.add(randomAdmin());
        adminList.add(randomAdmin());
        int result = umsAdminDao.insertBatch(adminList);
        LOGGER.info("testForeach result={}",result);
    }

    @Test
    void testForeach2(){
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);
        List<UmsAdmin> adminList = umsAdminDao.selectByIds(ids);
        LOGGER.info("testForeach2 result={}",adminList);
    }

    UmsAdmin randomAdmin() {
        UmsAdmin admin = new UmsAdmin();
        String randomNumbers = RandomUtil.randomNumbers(5);
        admin.setUsername("test" + randomNumbers);
        admin.setNickName("test" + randomNumbers);
        admin.setStatus(1);
        return admin;
    }

}
