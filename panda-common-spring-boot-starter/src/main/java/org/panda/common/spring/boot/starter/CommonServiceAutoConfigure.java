package org.panda.common.spring.boot.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 自动配置类
 * @ClassName CommonServiceAutoConfigure
 * @Copyright 炫彩互动
 * @Project panda-common-spring-boot-starter
 * @Author ota
 * @Create Date 2018年4月25日
 */
@Configuration
@ConditionalOnClass(CommonService.class)
@EnableConfigurationProperties(CommonServiceProps.class)
public class CommonServiceAutoConfigure {

    @Autowired
    private CommonServiceProps commonServiceProps;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "panda.common.service",value = "enabled",havingValue = "true")
    CommonService commonService() {
        return new CommonService(commonServiceProps.getVersion());
    }
}
