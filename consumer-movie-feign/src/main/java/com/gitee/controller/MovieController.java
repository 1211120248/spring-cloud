package com.gitee.controller;

import com.gitee.feign.UserFeign;
import com.gitee.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/user")
@RestController
public class MovieController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/{id}")
    public UserModel findById(@PathVariable("id") String id){
        return userFeign.findById(id);
    }

}
