package com.gitee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableEurekaServer
@SpringBootApplication
@RestController
public class EurekaApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }

    @GetMapping("/movie-instance")
    public List<ServiceInstance> showInfo(){
        List<String> services = this.discoveryClient.getServices();
        return this.discoveryClient.getInstances("consumer-movie-metadata");
    }

}
