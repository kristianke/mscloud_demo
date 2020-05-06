package com.cssth.springcloud.controller;


import com.cssth.esoc.entities.CommonResult;
import com.cssth.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult orderPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String paymentTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
