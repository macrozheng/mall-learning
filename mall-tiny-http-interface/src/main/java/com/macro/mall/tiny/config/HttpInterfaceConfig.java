package com.macro.mall.tiny.config;

import com.macro.mall.tiny.component.TokenHolder;
import com.macro.mall.tiny.remote.PmsBrandApi;
import com.macro.mall.tiny.remote.UmsAdminApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

    @Value("${remote.baseUrl}")
    private String baseUrl;
    @Autowired
    private TokenHolder tokenHolder;

    @Bean
    WebClient webClient() {
        return WebClient.builder()
                //添加全局默认请求头
                .defaultHeader("source", "http-interface")
                //给请求添加过滤器，添加自定义的认证头
                .filter((request, next) -> {
                    ClientRequest filtered = ClientRequest.from(request)
                            .header("Authorization", tokenHolder.getToken())
                            .build();
                    return next.exchange(filtered);
                })
                .baseUrl(baseUrl).build();
    }

    @Bean
    UmsAdminApi umsAdminApi(WebClient client) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(UmsAdminApi.class);
    }

    @Bean
    PmsBrandApi pmsBrandApi(WebClient client) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(PmsBrandApi.class);
    }
}
