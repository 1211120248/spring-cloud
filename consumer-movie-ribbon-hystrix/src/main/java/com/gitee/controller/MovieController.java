package com.gitee.controller;

import com.gitee.model.UserModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public UserModel findById(@PathVariable("id") String id){
        return restTemplate.getForObject("http://PROVIDER-USER/" + id,UserModel.class);
    }

    public UserModel findByIdFallback(String id){
        UserModel userModel = new UserModel();
        userModel.setName("default");
        userModel.setBalance(new BigDecimal(0.0));
        userModel.setAge(-1);
        userModel.setId(-1L);
        return userModel;
    }

}
