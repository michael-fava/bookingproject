package com.mfava.booking.core.config;

import com.mfava.booking.contract.enums.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author michaelfava
 */
@Slf4j
@Configuration
public class RabbitMQConfig {

    @Bean
    Exchange messageExchange() {
        return new FanoutExchange("message-exchange");
    }

    @Bean
    Queue messageAuditQueue() {
        return new Queue("message-audit-queue");
    }

    @Bean
    Exchange bookingExchange() {
        return new DirectExchange("booking-exchange");
    }


    @Bean
    Binding bookingExchangeBindMessageExchange() {
        return BindingBuilder.bind(bookingExchange()).to(messageExchange()).with("booking.*").noargs();
    }

    @Bean
    Binding messageAuditQueueBinding() {
        return BindingBuilder.bind(messageAuditQueue()).to(messageExchange()).with("booking.*").noargs();
    }


    @Bean
    Queue bookingAddQueue() {
        return new Queue("booking-add-queue");
    }

    @Bean
    Binding bookingAddQueueBinding() {
        return BindingBuilder.bind(bookingAddQueue()).to(bookingExchange()).with(OperationType.ADD.getOperationTag()).noargs();
    }

    @Bean
    Queue bookingEditQueue() {
        return new Queue("booking-edit-queue");
    }

    @Bean
    Binding bookingEditQueueBinding() {
        return BindingBuilder.bind(bookingEditQueue()).to(bookingExchange()).with(OperationType.UPDATE.getOperationTag()).noargs();
    }

    @Bean
    Queue bookingDeleteQueue() {
        return new Queue("booking-delete-queue");
    }

    @Bean
    Binding bookingDeleteQueueBinding() {
        return BindingBuilder.bind(bookingDeleteQueue()).to(bookingExchange()).with(OperationType.DELETE.getOperationTag()).noargs();
    }



}
