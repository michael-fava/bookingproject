package com.mfava.booking.api.config;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;

/**
 * @author michaelfava
 */
public class FeignConfig {

    @Bean
    public Client feignDefaultClient() {
        return new ApacheHttpClient();
    }

    @Bean
    public FeignErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }


}
