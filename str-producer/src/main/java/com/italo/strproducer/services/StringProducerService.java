package com.italo.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final View error;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic",message).whenComplete(
                (result,e) -> {
                    if (e != null) { // ENCONTROU EXCESSÃO !
                        log.error("Mensagem não enviada {} ",e.getMessage());
                    }
                    else {
                        log.info("Mensagem enviada {} ",message);
                        log.info("Partition: {},Offset: {}",
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                }
        );
    }

}
