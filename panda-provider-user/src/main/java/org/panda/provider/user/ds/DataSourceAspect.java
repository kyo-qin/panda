package org.panda.provider.user.ds;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     * 在dao层方法之前获取datasource对象之前在切面中指定当前线程数据源路由的key
     */
    @Before(value = "execution(* org.panda.provider.user.dao..*(..))")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        if (classz == null || classz.length == 0) {
            return;
        }
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DS.class)) {
                DS data = m.getAnnotation(DS.class);
                logger.info("方法选择的数据库类型：" + data.value());
                DataSourceHandler.putDataSource(data.value());
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }
}
