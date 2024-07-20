package com.italo.paymentservice.service.impl;

import com.italo.paymentservice.model.Payment;
import com.italo.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Payment received: {}" , payment);
        Thread.sleep(1000);
        log.info("Sending payment to Kafka");
        kafkaTemplate.send("payment-topic", payment);
        log.info("Payment Processed successfully");
    }
}
