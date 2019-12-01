package com.mfava.booking.api.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mfava.booking.contract.config.OffsetDateTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author michaelfava
 */
@Configuration
@Import(OffsetDateTimeModule.class)
public class JacksonConfig {


    @Bean
    public JavaTimeModule timeModule() {
        return new JavaTimeModule();
    }

}
