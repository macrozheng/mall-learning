package com.macro.mall.tiny.component;

import com.macro.mall.tiny.dto.MessageDto;
import io.github.majusko.pulsar.annotation.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Pulsar消息消费者
 * Created by macro on 2021/5/19.
 */
@Slf4j
@Component
public class PulsarRealConsumer {

    @PulsarConsumer(topic="bootTopic", clazz= MessageDto.class)
    public void consume(MessageDto message) {
        log.info("PulsarRealConsumer consume id:{},content:{}",message.getId(),message.getContent());
    }

}
