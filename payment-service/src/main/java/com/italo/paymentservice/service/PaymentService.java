package com.italo.paymentservice.service;

import com.italo.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
