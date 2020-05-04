package com.cssth.esoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_7002App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002App.class,args);
    }
}
