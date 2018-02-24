package org.panda.customer.user.ribbon;

import org.panda.customer.user.ribbon.entity.NPConfigInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserRibbonController {

    private static final Logger logger = LoggerFactory.getLogger(UserRibbonController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    // 原先是直接从http://localhost:7900/simple/1获取信息，现在可以从eureka上注册的服务名来获取（VIP
    // virtual IP）
    @GetMapping("/movie/{id}")
    public NPConfigInfo findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, NPConfigInfo.class);
    }

    // 通过loadBalancerClient选择实例，遵循@RibbonClient指定的配置类的ribbon配置
    @GetMapping("/test")
    public String test() {
        ServiceInstance si = loadBalancerClient.choose("microservice-provider-user");
        String result = "选择的实例信息：" + si.getHost() + ":" + si.getPort() + "/" + si.getServiceId();
        return result;
    }
}
