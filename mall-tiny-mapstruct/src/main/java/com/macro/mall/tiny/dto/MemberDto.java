package com.macro.mall.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 购物会员Dto
 * Created by macro on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    //与PO类型不同的属性
    private String birthday;
    //与PO名称不同的属性
    private String phoneNumber;
    private String icon;
    private Integer gender;
}
