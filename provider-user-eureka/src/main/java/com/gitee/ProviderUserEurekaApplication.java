package com.gitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderUserEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserEurekaApplication.class, args);
    }
}
