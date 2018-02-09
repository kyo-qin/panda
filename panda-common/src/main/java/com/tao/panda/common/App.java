package com.tao.panda.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description  APP启动类
 * @ClassName App
 * @Copyright 炫彩互动
 * @Project panda-common
 * @Author ota
 * @Create Date  2017年10月25日
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("开始");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        AppConfig config = context.getBean(AppConfig.class);
        logger.info("获取配置名：{}", config.getUserName());
        logger.info("获取用户名：{}", userService.getUserName());
        logger.info("获取用数据：{}", userService.getDataMS().getdName());
        context.close();
    }
}
