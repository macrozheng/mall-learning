package com.macro.mall.tiny;

import cn.torna.swaggerplugin.SwaggerPlugin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallTinyApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void pushDoc(){
        // 将文档推送到Torna服务中去，默认查找resources下的torna.json
        SwaggerPlugin.pushDoc();
    }

}
