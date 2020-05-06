package com.cssth.springcloud.service;

import com.cssth.esoc.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/payment/getById/{id}", method = RequestMethod.GET)
    public CommonResult getPayment(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String paymentFeignTimeout();

}
