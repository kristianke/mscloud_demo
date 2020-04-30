package com.cssth.esco.service;

import com.cssth.esco.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
