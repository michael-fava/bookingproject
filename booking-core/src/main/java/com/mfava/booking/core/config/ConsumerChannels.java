package com.mfava.booking.core.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author michaelfava
 */
public interface ConsumerChannels {

    String ADD_CHANNEL = "booking_add_channel";
    String EDIT_CHANNEL = "booking_edit_channel";
    String DELETE_CHANNEL = "booking_delete_channel";

    @Input(ADD_CHANNEL)
    SubscribableChannel add();

    @Input(EDIT_CHANNEL)
    SubscribableChannel edit();

    @Input(DELETE_CHANNEL)
    SubscribableChannel delete();



}
