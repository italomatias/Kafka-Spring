package com.italo.strconsumer.listeners;

import com.italo.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(String message){
        log.info("LISTENER RECEIVED MESSAGE: {}." , message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void listener2(String message){
        log.info("LISTENER 2 RECEIVED MESSAGE: {}." , message);
    }

    @StrConsumerCustomListener(groupId = "group-2")
    public void listener3(String message){
        log.info("LISTENER 3 RECEIVED MESSAGE: {}." , message);
    }

}
