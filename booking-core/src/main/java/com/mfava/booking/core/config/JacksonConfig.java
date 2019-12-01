package com.mfava.booking.core.config;

import com.mfava.booking.contract.config.OffsetDateTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author michaelfava
 */
@Configuration
public class JacksonConfig {

    @Bean
    public OffsetDateTimeModule offsetDateTimeModule(){return  new OffsetDateTimeModule();}
}
