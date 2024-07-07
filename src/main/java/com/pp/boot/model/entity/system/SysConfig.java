package com.pp.boot.model.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 参数配置表
 *
 * @TableName sys_config
 */
public class SysConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 参数主键
     */
    private Long configId;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    private String configType;

    /**
     * 创建部门
     */
    private Long createDept;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 参数主键
     */
    public Long getConfigId() {
        return configId;
    }

    /**
     * 参数主键
     */
    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    /**
     * 参数名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 参数名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 参数键名
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 参数键名
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * 参数键值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 参数键值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    /**
     * 系统内置（Y是 N否）
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 系统内置（Y是 N否）
     */
    public void setConfigType(String configType) {
        this.configType = configType;
    }

    /**
     * 创建部门
     */
    public Long getCreateDept() {
        return createDept;
    }

    /**
     * 创建部门
     */
    public void setCreateDept(Long createDept) {
        this.createDept = createDept;
    }

    /**
     * 创建者
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新者
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysConfig other = (SysConfig) that;
        return (this.getConfigId() == null ? other.getConfigId() == null : this.getConfigId().equals(other.getConfigId()))
                && (this.getConfigName() == null ? other.getConfigName() == null : this.getConfigName().equals(other.getConfigName()))
                && (this.getConfigKey() == null ? other.getConfigKey() == null : this.getConfigKey().equals(other.getConfigKey()))
                && (this.getConfigValue() == null ? other.getConfigValue() == null : this.getConfigValue().equals(other.getConfigValue()))
                && (this.getConfigType() == null ? other.getConfigType() == null : this.getConfigType().equals(other.getConfigType()))
                && (this.getCreateDept() == null ? other.getCreateDept() == null : this.getCreateDept().equals(other.getCreateDept()))
                && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConfigId() == null) ? 0 : getConfigId().hashCode());
        result = prime * result + ((getConfigName() == null) ? 0 : getConfigName().hashCode());
        result = prime * result + ((getConfigKey() == null) ? 0 : getConfigKey().hashCode());
        result = prime * result + ((getConfigValue() == null) ? 0 : getConfigValue().hashCode());
        result = prime * result + ((getConfigType() == null) ? 0 : getConfigType().hashCode());
        result = prime * result + ((getCreateDept() == null) ? 0 : getCreateDept().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", configId=").append(configId);
        sb.append(", configName=").append(configName);
        sb.append(", configKey=").append(configKey);
        sb.append(", configValue=").append(configValue);
        sb.append(", configType=").append(configType);
        sb.append(", createDept=").append(createDept);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}