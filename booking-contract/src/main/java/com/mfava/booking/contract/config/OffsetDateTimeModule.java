package com.mfava.booking.contract.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author michaelfava
 */
public class OffsetDateTimeModule extends SimpleModule {

    public OffsetDateTimeModule() {
        this.addSerializer(OffsetDateTime.class, new CustomOffsetDateTimeSerializer());
        this.addDeserializer(OffsetDateTime.class, new CustomOffsetDateTimeDeserializer());
    }

    public class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

        @Override
        public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }

    public class CustomOffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

        @Override
        public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return OffsetDateTime.of(
                    LocalDateTime.parse(
                            jsonParser.getValueAsString(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), ZoneOffset.UTC);
        }
    }


}