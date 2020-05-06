package com.cssth.myRule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MySelfRandomRule{

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}