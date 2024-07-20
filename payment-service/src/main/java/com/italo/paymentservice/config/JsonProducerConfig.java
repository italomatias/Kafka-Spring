package com.italo.paymentservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class JsonProducerConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory jsonProducerFactory() {
        var config = new HashMap<String, Object>();
        config.put("bootstrap.servers", properties.getBootstrapServers());
        config.put("Key.serializer", StringSerializer.class);
        config.put("Value.serializer", JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config,
                new StringSerializer() ,
                new JsonSerializer() );
    }

    @Bean
    public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory factory) {
        return new KafkaTemplate<>(factory);
    }

}
