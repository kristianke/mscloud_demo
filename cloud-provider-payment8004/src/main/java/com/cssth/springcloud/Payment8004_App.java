package com.cssth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004_App {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004_App.class,args);
    }
}
