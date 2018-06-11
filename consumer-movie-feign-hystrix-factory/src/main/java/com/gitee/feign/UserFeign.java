package com.gitee.feign;

import com.gitee.FeignFallbackFactory;
import com.gitee.model.UserModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "PROVIDER-USER",fallbackFactory = FeignFallbackFactory.class)
public interface UserFeign {

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public UserModel findById(@PathVariable("id") String id);

}
