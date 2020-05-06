package com.cssth.esoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZk80App {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZk80App.class,args);
    }
}
