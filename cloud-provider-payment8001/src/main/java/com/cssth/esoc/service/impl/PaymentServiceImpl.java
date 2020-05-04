package com.cssth.esoc.service.impl;

import com.cssth.esoc.dao.PaymentDao;
import com.cssth.esoc.entities.Payment;
import com.cssth.esoc.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao dao;

    @Override
    public int create(Payment payment) {
        return dao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return dao.getPaymentById(id);
    }
}
