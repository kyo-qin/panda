package org.panda.customer.user.ribbon.without.eureka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;

/**
 * @Description Ribbon自定义配置，不能放在ComponentScan路径下，或者排除掉这个类
 * @ClassName UserClientRobbinConfiguration
 * @Copyright 炫彩互动
 * @Project panda-customer-user-ribbon
 * @Author ota
 * @Create Date 2018年2月23日
 */
//加了@Configuration这个注解就会启动异常，奇怪
//@Configuration 
public class UserClientRobbinConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
      return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
      return new ConsistentHashRule();
    }
}
