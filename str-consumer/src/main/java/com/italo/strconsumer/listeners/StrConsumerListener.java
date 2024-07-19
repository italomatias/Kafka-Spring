package com.italo.strconsumer.listeners;

import com.italo.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows // THROW A EXCEPTION LIKE IN THE METHOD ASSINATURE
    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(String message){
        log.info("LISTENER RECEIVED MESSAGE: {}." , message);
        throw new IllegalArgumentException("EXCEPTION");
    }

    /*@StrConsumerCustomListener(groupId = "group-1")
    public void listener2(String message){
        log.info("LISTENER 2 RECEIVED MESSAGE: {}." , message);
    }*/

    @StrConsumerCustomListener(groupId = "group-2")
    public void listener3(String message){
        log.info("LISTENER 3 RECEIVED MESSAGE: {}." , message);
    }

    @KafkaListener(groupId = "group-3", containerFactory = "validMessageConsumerFactory", topics = "str-topic")
    public void listener4(String message){
        log.info("LISTENER 4 RECEIVED MESSAGE: {}." , message);
    }


}
