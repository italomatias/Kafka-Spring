package com.italo.paymentservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {

    private final KafkaProperties propos;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var config = new HashMap<String,Object>();
        config.put("bootstrap.servers", propos.getBootstrapServers());
        return new KafkaAdmin(config);

    }

    @Bean
    public KafkaAdmin.NewTopics newTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("payment-topic")
                        .partitions(1)
                        .build());
    }

}
