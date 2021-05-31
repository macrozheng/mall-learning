package com.macro.mall.tiny.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Kafka消息生产者
 * Created by macro on 2021/5/19.
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String message){
        kafkaTemplate.send("bootTopic",message);
    }
}
