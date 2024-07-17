package com.italo.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1",topics = "str-topic",containerFactory = "strConsumerFactory" )
    public void listener(String message){
        log.info("LISTENER RECEIVED MESSAGE: {}." , message);
    }

    @KafkaListener(groupId = "group-1",topics = "str-topic",containerFactory = "strConsumerFactory" )
    public void listener2(String message){
        log.info("LISTENER 2 RECEIVED MESSAGE: {}." , message);
    }

    @KafkaListener(groupId = "group-2",topics = "str-topic",containerFactory = "strConsumerFactory" )
    public void listener3(String message){
        log.info("LISTENER 3 RECEIVED MESSAGE: {}." , message);
    }

}
