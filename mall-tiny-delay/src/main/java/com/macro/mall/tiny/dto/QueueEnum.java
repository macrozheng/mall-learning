package com.macro.mall.tiny.dto;

import lombok.Getter;

/**
 * 消息队列枚举配置
 * Created by macro on 2018/9/14.
 */
@Getter
public enum QueueEnum {
    /**
     * 插件实现延迟队列
     */
    QUEUE_ORDER_PLUGIN_CANCEL("mall.order.direct.plugin", "mall.order.cancel.plugin", "mall.order.cancel.plugin");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
