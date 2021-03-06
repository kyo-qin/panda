package org.panda.customer.user.config;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class NPConfigInfoFeignConfiguration {

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();//用feign的defaultcontract就只支持feign的注解
    }

//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password123");
//    }

}
