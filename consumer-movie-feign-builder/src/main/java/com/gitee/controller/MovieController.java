package com.gitee.controller;

import com.gitee.feign.UserFeign;
import com.gitee.model.UserModel;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientProperties;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@Import(FeignClientsConfiguration.class)
@RestController
@Configuration
public class MovieController {

    private UserFeign userFeign;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userFeign = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","admin"))
                .target(UserFeign.class,"http://PROVIDER-USER/");
    }



    @GetMapping("/{id}")
    public UserModel findById(@PathVariable("id") String id){
        return userFeign.findById(id);
    }

}
