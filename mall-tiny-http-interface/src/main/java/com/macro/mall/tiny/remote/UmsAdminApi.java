package com.macro.mall.tiny.remote;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.domain.LoginInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;


/**
 * 定义Http接口，用于调用远程的UmsAdmin服务
 * Created by macro on 2022/1/19.
 */
@HttpExchange
public interface UmsAdminApi {

    @PostExchange("admin/login")
    CommonResult<LoginInfo> login(@RequestParam("username") String username, @RequestParam("password") String password);
}
