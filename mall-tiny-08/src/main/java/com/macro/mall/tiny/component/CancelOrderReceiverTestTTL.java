package com.macro.mall.tiny.component;

import com.macro.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * 接受到的消息
 * Created by macro on  2018/9/14.
 */
@Component
//@RabbitListener(queues = "mall.order.cancel.ttl")
public class CancelOrderReceiverTestTTL {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiverTestTTL.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handle(Long orderId) {
        LOGGER.info("收到mall.order.cancel.ttl消息--->receive delay message orderId:{}", orderId);
    }
}
