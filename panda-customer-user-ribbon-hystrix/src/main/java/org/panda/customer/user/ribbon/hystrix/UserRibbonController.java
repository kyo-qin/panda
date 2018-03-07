package org.panda.customer.user.ribbon.hystrix;

import org.panda.customer.user.ribbon.hystrix.entity.NPConfigInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class UserRibbonController {

    private static final Logger logger = LoggerFactory.getLogger(UserRibbonController.class);

    @Autowired
    private RestTemplate restTemplate;

    // 原先是直接从http://localhost:7900/simple/1获取信息，现在可以从eureka上注册的服务名来获取（VIP
    // virtual IP）
    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "40000") })
    public NPConfigInfo findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, NPConfigInfo.class);
    }

    public NPConfigInfo findByIdFallback(Long id) {
        NPConfigInfo npConfigInfo = new NPConfigInfo();
        npConfigInfo.setConfigCode("fallBack");
        npConfigInfo.setId(-1);
        npConfigInfo.setConfigValue("fallback");
        return npConfigInfo;

    }
}
