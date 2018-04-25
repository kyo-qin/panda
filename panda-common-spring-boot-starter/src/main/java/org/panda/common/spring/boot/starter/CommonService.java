package org.panda.common.spring.boot.starter;

/**
 * @Description 服务提供类
 * @ClassName CommonService
 * @Copyright 炫彩互动
 * @Project panda-common-spring-boot-starter
 * @Author ota
 * @Create Date 2018年4月25日
 */
public class CommonService {

    private String version;

    public CommonService(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

}
