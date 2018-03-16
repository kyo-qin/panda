package org.panda.customer.user.ribbon.hystrix.turbine.entity;

import java.util.Date;

public class NPConfigInfo {

    private long id;

    private String configCode;

    private String configValue;

    private String remark;

    private Date inserTime;

    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInserTime() {
        return inserTime;
    }

    public void setInserTime(Date inserTime) {
        this.inserTime = inserTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
