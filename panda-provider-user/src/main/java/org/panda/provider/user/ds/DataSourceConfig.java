package org.panda.provider.user.ds;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @Description 数据源配置
 * @ClassName DataSourceConfig
 * @Copyright 炫彩互动
 * @Project panda-common
 * @Author ota
 * @Create Date 2017年10月31日
 */
@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * 只读数据源
     * 
     * @return
     */
    @Bean(destroyMethod = "close", initMethod = "init", name = "readDataSource")
    public DruidDataSource readDataSource() {
        DruidDataSource dds = null;
        try {
            dds = new DruidDataSource();
            dds.setUrl("jdbc:mysql://192.168.251.51:3306/egame_netpay?characterEncoding=utf8");
            dds.setUsername("root");
            dds.setPassword("test$11");
            dds.setInitialSize(1);
            dds.setMinIdle(1);
            dds.setMaxActive(200);
            dds.setMaxWait(60000);
            dds.setTimeBetweenEvictionRunsMillis(60000);
            dds.setMinEvictableIdleTimeMillis(300000);
            dds.setValidationQuery("SELECT 'x'");
            dds.setTestWhileIdle(true);
            dds.setTestOnBorrow(false);
            dds.setTestOnReturn(false);
            dds.setPoolPreparedStatements(true);
            dds.setMaxPoolPreparedStatementPerConnectionSize(20);
            dds.setFilters("stat");
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return dds;
    }

    /**
     * 只写数据源
     * 
     * @return
     */
    @Bean(destroyMethod = "close", initMethod = "init", name = "writeDataSource")
    @Primary
    public DruidDataSource writeDataSource() {
        DruidDataSource dds = null;
        try {
            dds = new DruidDataSource();
            dds.setUrl("jdbc:mysql://192.168.251.51:3306/egame_netpay?characterEncoding=utf8");
            dds.setUsername("root");
            dds.setPassword("test$11");
            dds.setInitialSize(1);
            dds.setMinIdle(1);
            dds.setMaxActive(200);
            dds.setMaxWait(60000);
            dds.setTimeBetweenEvictionRunsMillis(60000);
            dds.setMinEvictableIdleTimeMillis(300000);
            dds.setValidationQuery("SELECT 'x'");
            dds.setTestWhileIdle(true);
            dds.setTestOnBorrow(false);
            dds.setTestOnReturn(false);
            dds.setPoolPreparedStatements(true);
            dds.setMaxPoolPreparedStatementPerConnectionSize(20);
            dds.setFilters("stat");
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return dds;
    }

    @Bean(name = "dataSource")
    public DataSourceRetriver dataSource(@Autowired @Qualifier("readDataSource") javax.sql.DataSource readDataSource,
            @Autowired @Qualifier("writeDataSource") javax.sql.DataSource writeDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put("write_egame_charge_sms", writeDataSource);
        targetDataSources.put("read_egame_charge_sms", readDataSource);
        DataSourceRetriver dr = new DataSourceRetriver();
        dr.setTargetDataSources(targetDataSources);
        dr.setDefaultTargetDataSource(readDataSource);
        return dr;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSourceRetriver dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        ssfb.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        ssfb.setMapperLocations(new ClassPathResource[] { new ClassPathResource("mapper/ConfigMapper.xml") });
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.panda.provider.user");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager(@Autowired DataSource writeDataSource) {
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(writeDataSource);
        return tx;
    }
    
    
}
