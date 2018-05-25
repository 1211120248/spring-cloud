package com.gitee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@SpringBootApplication
public class MovieApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/movie-instance")
    public List<ServiceInstance> showInfo(){
        List<String> services = this.discoveryClient.getServices();
        return this.discoveryClient.getInstances("consumer-movie-metadata");
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
