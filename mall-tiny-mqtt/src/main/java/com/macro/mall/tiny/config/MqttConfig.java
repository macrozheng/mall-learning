package com.macro.mall.tiny.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MQTT相关配置
 * Created by macro on 2020/9/15.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
@ConfigurationProperties(prefix = "rabbitmq.mqtt")
public class MqttConfig {
    /**
     * RabbitMQ连接用户名
     */
    private String username;
    /**
     * RabbitMQ连接密码
     */
    private String password;
    /**
     * RabbitMQ的MQTT默认topic
     */
    private String defaultTopic;
    /**
     * RabbitMQ的MQTT连接地址
     */
    private String url;
}
