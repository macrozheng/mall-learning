package com.macro.mall.tiny.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录信息封装
 * Created by macro on 2022/1/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginInfo {
    //登录token
    private String token;
    //登录token前缀
    private String tokenHead;
}
