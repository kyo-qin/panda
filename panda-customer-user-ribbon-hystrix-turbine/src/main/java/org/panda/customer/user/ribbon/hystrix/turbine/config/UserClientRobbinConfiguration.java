package org.panda.customer.user.ribbon.hystrix.turbine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @Description Ribbon自定义配置，不能放在ComponentScan路径下，或者排除掉这个类
 * @ClassName UserClientRobbinConfiguration
 * @Copyright 炫彩互动
 * @Project panda-customer-user-ribbon
 * @Author ota
 * @Create Date 2018年2月23日
 */
public class UserClientRobbinConfiguration {

    @Autowired
    IClientConfig config;

    /**
     * 自定义负载均衡策略，随机访问策略
     * 
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
