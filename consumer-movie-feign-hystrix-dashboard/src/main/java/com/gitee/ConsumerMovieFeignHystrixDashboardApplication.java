package com.gitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard  //支持hystrix dashboard
public class ConsumerMovieFeignHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignHystrixDashboardApplication.class, args);
    }
}
