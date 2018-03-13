package org.panda.customer.user.feign.hystrix;

import org.panda.customer.user.config.NPConfigInfoFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Param;
import feign.RequestLine;

/**
 * @Description feign client类
 * @ClassName NPConfigInfoFeignClient
 * @Copyright 炫彩互动
 * @Project panda-customer-user-feign-hystrix
 * @Author ota
 * @Create Date 2018年3月13日
 */
@FeignClient(name = "microservice-provider-user", configuration = NPConfigInfoFeignConfiguration.class, fallback = NPConfigInfoFeignClientFallback.class)
public interface NPConfigInfoFeignClient {

    @RequestLine("GET /simple/{id}")
    //@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public NPConfigInfo findById(@Param("id") Integer id);

}
