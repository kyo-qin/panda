package com.tao.panda.common.test;

import java.util.List;

import com.tao.panda.common.ds.DS;


/**
 * Description 配置信息DAO
 * 
 * @ClassName NPConfigDao
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
public interface NPConfigDao {

    @DS("read_egame_charge_sms")
    public NPConfigInfo getNPConfigInfoByConfigCodeAndType(String configCode,int configType);
    
    @DS("read_egame_charge_sms")
    public List<NPConfigInfo> getAllNPConfigInfos();

}
