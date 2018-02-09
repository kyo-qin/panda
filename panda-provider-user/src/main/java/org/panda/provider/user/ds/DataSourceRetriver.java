package org.panda.provider.user.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DataSourceRetriver extends AbstractRoutingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceRetriver.class);

    /**
     * 获取与数据源相关的key 此key是Map<String,DataSource> resolvedDataSources 中与数据源绑定的key值
     * 在通过determineTargetDataSource获取目标数据源时使用
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceHandler.getDataSource();
        logger.info("当前使用数据源：{}", dataSource);
        return dataSource;
    }

}
