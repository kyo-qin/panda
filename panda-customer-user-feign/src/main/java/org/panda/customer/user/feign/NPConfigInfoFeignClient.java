package org.panda.customer.user.feign;

import org.panda.customer.user.config.NPConfigInfoFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = NPConfigInfoFeignConfiguration.class)
public interface NPConfigInfoFeignClient {

    //@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    // @GetMapping("/simple/{id}")
    @RequestLine("GET /simple/{id}")
    public NPConfigInfo findById(@PathVariable("id") Integer id);// @PathVariable得配置值，不然无法启动
}
