package org.panda.customer.user.feign.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * @Description hystrix fallback factory
 * @ClassName NPConfigInfoFeignClientFallbackFactory
 * @Copyright 炫彩互动
 * @Project panda-customer-user-feign-hystrix
 * @Author ota
 * @Create Date 2018年3月14日
 */
@Component
public class NPConfigInfoFeignClientFallbackFactory implements FallbackFactory<NPConfigInfoFeignClient> {

    private static final Logger logger = LoggerFactory.getLogger(NPConfigInfoFeignClientFallbackFactory.class);

    @Override
    public NPConfigInfoFeignClient create(final Throwable cause) {

        return new NPConfigInfoFeignClientWithFactory() {

            @Override
            public NPConfigInfo findById(Integer id) {
                NPConfigInfo info = new NPConfigInfo();
                info.setId(-20000);
                info.setConfigCode("info");
                info.setConfigValue("hystrix fallback factory");
                info.setRemark("its hystrix fallback factory method");
                logger.info("method fallback, cause: {}", cause.getLocalizedMessage());
                return info;
            }

        };
    }

}
