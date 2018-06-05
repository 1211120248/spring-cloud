package com.gitee.feign;

import com.gitee.FeignConfiguration;
import com.gitee.model.UserModel;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-user",configuration = FeignConfiguration.class)
public interface UserFeign {

    @RequestLine("GET /{id}")
    public UserModel findById(@Param("id") String id);

}
