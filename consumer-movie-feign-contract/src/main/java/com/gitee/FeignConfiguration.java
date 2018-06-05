package com.gitee;

import feign.Contract;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     * 修改契约为feign原生的合同
     * @return
     */
    @Bean
    public Contract contract(){
        return new feign.Contract.Default();
    }

}
