package com.italo.paymentservice.resource;

import com.italo.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResorce {

    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
