package com.macro.mall.tiny.component;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 给请求添加登录Token头的拦截器
 * Created by macro on 2022/1/19.
 */
@Component
public class TokenInterceptor extends BasePathMatchInterceptor {
    @Autowired
    private TokenHolder tokenHolder;

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (tokenHolder.getToken() != null) {
            request = request.newBuilder()
                    .header("Authorization", tokenHolder.getToken())
                    .build();
        }
        return chain.proceed(request);
    }
}
