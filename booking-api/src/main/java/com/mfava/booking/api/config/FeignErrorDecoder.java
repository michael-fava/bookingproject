package com.mfava.booking.api.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author michaelfava
 */
@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                log.error("Status code " + response.status() + ", methodKey = " + methodKey);
            case 404: {
                log.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status() + ", methodKey = " + methodKey);
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "<You can add error message description here>");
            }
            default:
                return new Exception(response.reason());
        }
    }

}
