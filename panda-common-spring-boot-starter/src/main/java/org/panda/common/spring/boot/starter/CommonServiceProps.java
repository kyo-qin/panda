package org.panda.common.spring.boot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @Description 通过配置文件application.yml取得值
 * @ClassName CommonServiceProps
 * @Copyright 炫彩互动
 * @Project panda-common-spring-boot-starter
 * @Author ota
 * @Create Date 2018年4月25日
 */
@ConfigurationProperties("panda.common.service")
public class CommonServiceProps {

    private String version;

    private String enabled;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
