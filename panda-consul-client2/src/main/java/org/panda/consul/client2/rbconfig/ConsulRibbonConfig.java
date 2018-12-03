package org.panda.consul.client2.rbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

public class ConsulRibbonConfig {

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
