package org.panda.consul.client2;

import org.panda.consul.client2.rbconfig.ConsulRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "org.panda.consul.client2" }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.panda.consul.client2.rbconfig.*") })
@RibbonClient(name = "microservice-consumer-user-ribbon", configuration = ConsulRibbonConfig.class)
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
