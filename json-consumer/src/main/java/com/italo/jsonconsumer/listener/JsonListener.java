package com.italo.jsonconsumer.listener;

import com.italo.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic" , groupId = "pagamento-3" , containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Message Recieved ... {}" , payment);
        sleep(2000);
        log.info("Payment Aproved");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic" , groupId = "pdf-1" , containerFactory = "jsonContainerFactory")
    public void pdfGenerator(){
        log.info("Message Recieved ...");
        sleep(2000);
        log.info("Gerando PDF");
        sleep(2000);
        log.info("PDF GERADO");
    }
}
