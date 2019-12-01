package com.mfava.booking.api.integration;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author michaelfava
 */

@Service
@AllArgsConstructor
public class QueueProducer {

    public static final String MESSAGE_EXCHANGE = "message-exchange";

    private AmqpTemplate amqpTemplate;

    public Object sendMessageGetReply(Message message) {
        message.getHeaders().putIfAbsent("reply-to", "amq.rabbitmq.reply-to");
        Object response = amqpTemplate.convertSendAndReceive(MESSAGE_EXCHANGE, message.getHeaders().get("message-type").toString(), message);
        return response;
    }

    public void sendMessage(Message message) {
        amqpTemplate.convertAndSend(MESSAGE_EXCHANGE, message.getHeaders().get("message-type").toString(), message);
    }

}
