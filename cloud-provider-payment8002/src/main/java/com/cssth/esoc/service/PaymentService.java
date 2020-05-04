package com.cssth.esoc.service;

import com.cssth.esoc.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
