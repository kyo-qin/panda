package org.panda.provider.user;

import java.util.List;

import javax.annotation.Resource;

import org.panda.provider.user.dao.NPConfigDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description 联网支付，服务类
 * 
 * @ClassName NetPayService
 *
 * @Copyright 炫彩互动
 * 
 * @Project egame.netpay.core
 * 
 * @Author ota
 * 
 * @Create Date 2017年7月18日
 * 
 * @Modified by none
 *
 * @Modified Date
 */
@Service
@Transactional
public class NetPayService {

    private static final Logger logger = LoggerFactory.getLogger(NetPayService.class);

    private volatile static NetPayService instance = null;

    private static byte[] lock = new byte[0];

    @Resource
    NPConfigDao configDao;

    protected NetPayService() {
        super();
    }

    static public NetPayService getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    logger.info("初始化NetPayService实例");
                    instance = new NetPayService();
                }
            }
        }
        return instance;
    }

    public NPConfigInfo getNPConfigInfoByConfigCodeAndType(String configCode, int configType) {
        
        return configDao.getNPConfigInfoByConfigCodeAndType(configCode, configType);
    }

    public List<NPConfigInfo> getAllNPConfigInfos() {
        logger.info("获取所有配置");
        return configDao.getAllNPConfigInfos();
    }
}
