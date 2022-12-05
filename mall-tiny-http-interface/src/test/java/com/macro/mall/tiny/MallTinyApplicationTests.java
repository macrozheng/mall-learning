package com.macro.mall.tiny;

import cn.hutool.json.JSONUtil;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.domain.LoginInfo;
import com.macro.mall.tiny.remote.UmsAdminApi;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MallTinyApplicationTests {

    @Autowired
    private UmsAdminApi adminApi;

    @Test
    public void contextLoads() {
        CommonResult<LoginInfo> loginInfo = adminApi.login("admin", "123456");
        log.info("result:{}", JSONUtil.toJsonStr(loginInfo));
    }

}
