package com.macro.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @auther macrozheng
 * @description MyBatis配置类
 * @date 2019/4/8
 * @github https://github.com/macrozheng
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.macro.mall.tiny.mbg.mapper","com.macro.mall.tiny.dao"})
public class MyBatisConfig {
}
