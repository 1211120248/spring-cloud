package com.gitee.controller;

import com.gitee.model.UserModel;
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


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/user/{id}")
    public UserModel findById(@PathVariable("id") String id){
        return restTemplate.getForObject("http://PROVIDER-USER/" + id,UserModel.class);
    }

    @GetMapping("/log-instance")
    public String logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient
                .choose("provider-user");
            return String.format("{%s}:{%s}:{%s}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

}
