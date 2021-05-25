package com.macro.mall.tiny.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by macro on 2020/6/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class PayloadDto {
    @ApiModelProperty("主题")
    private String sub;
    @ApiModelProperty("签发时间")
    private Long iat;
    @ApiModelProperty("过期时间")
    private Long exp;
    @ApiModelProperty("JWT的ID")
    private String jti;
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("用户拥有的权限")
    private List<String> authorities;
}
