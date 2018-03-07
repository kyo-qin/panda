package org.panda.customer.user.ribbon.hystrix;

import org.panda.customer.user.ribbon.hystrix.config.UserClientRobbinConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
// 不扫描ribbon的配置类
@ComponentScan(basePackages = { "org.panda.customer.user.ribbon" }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, pattern = "org.panda.customer.user.ribbon.config.*") })
@RibbonClient(name = "microservice-provider-user", configuration = UserClientRobbinConfiguration.class)
public class App {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
