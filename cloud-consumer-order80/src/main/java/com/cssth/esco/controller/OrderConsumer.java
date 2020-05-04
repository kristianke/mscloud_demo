package com.cssth.esco.controller;

import com.cssth.esoc.entities.CommonResult;
import com.cssth.esoc.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderConsumer {

    final String url = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult createPayment(Payment serial){
        CommonResult commonResult = restTemplate.postForObject(url + "/payment/add", serial, CommonResult.class);
        return commonResult;
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        log.info("获取订单！");
        return restTemplate.getForObject(url+"/payment/getById/"+id,CommonResult.class);
    }

    @GetMapping("/test")
    public String getTest(){
        return "ABC";
    }
}
