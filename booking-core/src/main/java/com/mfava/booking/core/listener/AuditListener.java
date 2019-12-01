package com.mfava.booking.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * @author michaelfava
 */
@Slf4j
@Component
public class AuditListener {


    @RabbitListener(queues = "message-audit-queue")
    public void auditMessage(GenericMessage message) {
       log.info("Message Headers : {}", message.getHeaders());
       log.info("Message Payload : {}", message.getPayload());
    }

}
