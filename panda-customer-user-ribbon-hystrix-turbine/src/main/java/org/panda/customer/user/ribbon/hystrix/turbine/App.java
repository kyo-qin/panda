package org.panda.customer.user.ribbon.hystrix.turbine;

import org.panda.customer.user.ribbon.hystrix.turbine.config.UserClientRobbinConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
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
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableTurbine
// 不扫描ribbon的配置类
@ComponentScan(basePackages = { "org.panda.customer.user.ribbon" }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.panda.customer.user.ribbon.hystrix.turbine.config.*") })
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
