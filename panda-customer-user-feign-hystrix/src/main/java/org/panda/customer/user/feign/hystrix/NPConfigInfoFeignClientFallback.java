package org.panda.customer.user.feign.hystrix;

import org.springframework.stereotype.Component;

/**
 * @Description feigon对应的hystrixfallback类，需要实例化，所以加上component注解
 * @ClassName NPConfigInfoFeignClientFallback
 * @Copyright 炫彩互动
 * @Project panda-customer-user-feign-hystrix
 * @Author ota
 * @Create Date 2018年3月13日
 */
@Component
public class NPConfigInfoFeignClientFallback implements NPConfigInfoFeignClient {

    @Override
    public NPConfigInfo findById(Integer id) {
        NPConfigInfo info = new NPConfigInfo();
        info.setId(-10000);
        info.setConfigCode("info");
        info.setConfigValue("hystrix fallback");
        info.setRemark("its hystrix fallback method");
        return info;
    }

}
