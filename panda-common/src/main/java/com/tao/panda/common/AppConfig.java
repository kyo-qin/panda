package com.tao.panda.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.tao.panda.common")
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Value("${app.config.username}")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bean
    public DataMS dataMS() {
        logger.info("init dataMs...");
        DataMS dataMs = new DataMS();
        dataMs.setdName("andrew");
        return dataMs;
    }

}
