package org.panda.customer.user.config;

import org.springframework.context.annotation.Bean;

import feign.Contract;
import feign.Logger;

public class TestFeignConfiguration {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password123");
//    }

}
