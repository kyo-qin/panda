package org.panda.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.annotation.Order;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
}
