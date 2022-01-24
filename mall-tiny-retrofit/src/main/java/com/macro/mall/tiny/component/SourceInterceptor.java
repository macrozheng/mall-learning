package com.macro.mall.tiny.component;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseGlobalInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 全局拦截器，给请求添加source头
 * Created by macro on 2022/1/19.
 */
@Component
public class SourceInterceptor extends BaseGlobalInterceptor {
    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("source", "retrofit")
                .build();
        return chain.proceed(newReq);
    }
}
