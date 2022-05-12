package com.macro.mall.tiny.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.erupt.core.annotation.EruptScan;

/**
 * Created by macro on 2021/4/13.
 */
@Configuration
@ComponentScan({"xyz.erupt","com.macro.mall.tiny"})
@EntityScan({"xyz.erupt","com.macro.mall.tiny"})
@EruptScan({"xyz.erupt","com.macro.mall.tiny"})
public class EruptConfig {
}
