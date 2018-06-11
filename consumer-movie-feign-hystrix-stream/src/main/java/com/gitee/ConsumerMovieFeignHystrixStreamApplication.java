package com.gitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker //需要加上此注解才能看到hystrix实时监控
public class ConsumerMovieFeignHystrixStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignHystrixStreamApplication.class, args);
    }
}
