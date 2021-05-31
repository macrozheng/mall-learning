package com.macro.mall.tiny.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka消息消费者
 * Created by macro on 2021/5/19.
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "bootTopic")
    public void processMessage(String content) {
        log.info("consumer processMessage : {}",content);
    }

}
