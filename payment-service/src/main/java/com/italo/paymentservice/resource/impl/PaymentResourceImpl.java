package com.italo.paymentservice.resource.impl;

import com.italo.paymentservice.model.Payment;
import com.italo.paymentservice.resource.PaymentResorce;
import com.italo.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController// It is a controller rest
@RequestMapping(value = "/payments") // It is the endpoint name
public class PaymentResourceImpl implements PaymentResorce {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
