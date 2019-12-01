package com.mfava.booking.api.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mfava.booking.contract.config.OffsetDateTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author michaelfava
 */
@Configuration
public class JacksonConfig {


    @Bean
    public JavaTimeModule timeModule() {
        return new JavaTimeModule();
    }

    @Bean
    public OffsetDateTimeModule offsetDateTimeModule() {
        return new OffsetDateTimeModule();
    }

}
