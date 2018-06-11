package com.gitee;

import com.gitee.feign.UserFeign;
import com.gitee.model.UserModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class FeignClientFallback implements UserFeign{
    @Override
    public UserModel findById(String id) {
        UserModel userModel = new UserModel();
        userModel.setId(-1l);
        userModel.setUsername("默认用户");
        userModel.setAge(-1);
        userModel.setBalance(new BigDecimal(0));
        return userModel;
    }
}
