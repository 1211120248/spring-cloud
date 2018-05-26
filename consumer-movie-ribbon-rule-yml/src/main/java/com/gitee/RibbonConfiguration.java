package com.gitee;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //负载均衡策略有很多实现 随机、性能、权重、轮训等等
        //负载均衡策略 随机
        return new RandomRule();
    }

}
