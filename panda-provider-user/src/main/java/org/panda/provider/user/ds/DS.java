package org.panda.provider.user.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description 数据源标示，用于注解方式获取数据源
 * 
 * @ClassName DataSource
 * 
 * @Copyright 炫彩互动
 * 
 * @Project egame.netpay.common
 * 
 * @Author ota
 * 
 * @Create Date 2017-5-9
 * 
 * @Modified by none
 * 
 * @Modified Date
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DS {
    String value();
}
