package com.macro.mall.tiny.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录token存储（在Session中）
 * Created by macro on 2022/1/19.
 */
@Component
public class TokenHolder {
    /**
     * 添加token
     */
    public void putToken(String token) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        request.getSession().setAttribute("token", token);
    }

    /**
     * 获取token
     */
    public String getToken() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        Object token = request.getSession().getAttribute("token");
        if(token!=null){
            return (String) token;
        }
        return null;
    }

}
