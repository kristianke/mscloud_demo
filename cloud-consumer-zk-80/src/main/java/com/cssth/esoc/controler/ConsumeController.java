package com.cssth.esoc.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;

    private final String url = "http://cloud-provider-payment";

    @GetMapping(value = "/consumer/payment/zk")
    public String orderController(){
        String forObject = restTemplate.getForObject(url + "/payment/zk", String.class);
        return forObject;
    }
}
