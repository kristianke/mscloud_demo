package com.cssth.esco;

import com.cssth.myRule.MySelfRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRandomRule.class)
@SpringBootApplication
@EnableEurekaClient
public class Consumer_80App {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_80App.class,args);
    }
}
