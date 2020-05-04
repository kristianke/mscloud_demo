package com.cssth.esoc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment_8001App {
    public static void main(String[] args) {
        SpringApplication.run(Payment_8001App.class,args);
    }
}
