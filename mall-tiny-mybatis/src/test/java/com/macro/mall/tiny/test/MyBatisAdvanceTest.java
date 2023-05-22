package com.macro.mall.tiny.test;

import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.dao.UmsResourceCategoryDao;
import com.macro.mall.tiny.dao.UmsResourceDao;
import com.macro.mall.tiny.domain.UmsResourceCategoryExt;
import com.macro.mall.tiny.domain.UmsResourceExt;
import com.macro.mall.tiny.model.UmsResource;
import com.macro.mall.tiny.service.UmsResourceService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther macrozheng
 * @description MyBatis高级查询测试
 * @date 2022/10/20
 * @github https://github.com/macrozheng
 */
@SpringBootTest
public class MyBatisAdvanceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisAdvanceTest.class);

    @Autowired
    private UmsResourceDao umsResourceDao;

    @Autowired
    private UmsResourceCategoryDao umsResourceCategoryDao;

    @Autowired
    private UmsResourceService umsResourceService;

    @Test
    void testOneToOne(){
        UmsResourceExt umsResourceExt = umsResourceDao.selectResourceWithCategory(1L);
        LOGGER.info("testOneToOne category={}",umsResourceExt.getCategory());
    }

    @Test
    void testAssociation(){
        UmsResourceExt umsResourceExt = umsResourceDao.selectResourceWithCategory2(1L);
        LOGGER.info("testAssociation category={}",umsResourceExt.getCategory());
    }

    @Test
    void testOneToMany(){
        UmsResourceCategoryExt umsResourceCategoryExt = umsResourceCategoryDao.selectCategoryWithResource(1L);
        LOGGER.info("testOneToMany resourceList={}",umsResourceCategoryExt.getResourceList());
    }

    @Test
    void testPage() {
        int pageNum = 1;
        int pageSize = 5;
        PageInfo<UmsResource> pageInfo = umsResourceService.page(pageNum, pageSize, 1L);
        LOGGER.info("testPage total={},pages={},resourceList={}", pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }
}
