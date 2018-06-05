package com.gitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @// TODO: 2018/6/5 由于maven更新不一下来最新的spring cloud版本,当前版本压缩有一些问题，等后面完善此demo
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerMovieFeignCompressApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignCompressApplication.class, args);
    }
}
