package com.macro.mall.tiny.config;

import com.macro.mall.tiny.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息队列配置
 * Created by macro on 2018/9/14.
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 订单延迟插件消息队列所绑定的交换机
     */
    @Bean
    CustomExchange  orderPluginDirect() {
        //创建一个自定义交换机，可以发送延迟消息
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getExchange(), "x-delayed-message",true, false,args);
    }

    /**
     * 订单延迟插件队列
     */
    @Bean
    public Queue orderPluginQueue() {
        return new Queue(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getName());
    }

    /**
     * 将订单延迟插件队列绑定到交换机
     */
    @Bean
    public Binding orderPluginBinding(CustomExchange orderPluginDirect,Queue orderPluginQueue) {
        return BindingBuilder
                .bind(orderPluginQueue)
                .to(orderPluginDirect)
                .with(QueueEnum.QUEUE_ORDER_PLUGIN_CANCEL.getRouteKey())
                .noargs();
    }

}
