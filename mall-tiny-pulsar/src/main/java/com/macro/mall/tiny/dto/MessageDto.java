package com.macro.mall.tiny.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 消息封装
 * Created by macro on 2021/5/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MessageDto {
    private Long id;
    private String content;
}
