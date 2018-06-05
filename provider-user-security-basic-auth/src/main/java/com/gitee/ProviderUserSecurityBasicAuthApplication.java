package com.gitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderUserSecurityBasicAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserSecurityBasicAuthApplication.class, args);
    }
}
