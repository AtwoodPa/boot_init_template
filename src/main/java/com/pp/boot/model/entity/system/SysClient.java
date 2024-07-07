package com.pp.boot.model.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统授权表
 * @TableName sys_client
 */
public class SysClient implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端key
     */
    private String clientKey;

    /**
     * 客户端秘钥
     */
    private String clientSecret;

    /**
     * 授权类型
     */
    private String grantType;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * token活跃超时时间
     */
    private Integer activeTimeout;

    /**
     * token固定超时
     */
    private Integer timeout;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

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

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 客户端id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 客户端id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 客户端key
     */
    public String getClientKey() {
        return clientKey;
    }

    /**
     * 客户端key
     */
    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    /**
     * 客户端秘钥
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * 客户端秘钥
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * 授权类型
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * 授权类型
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    /**
     * 设备类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设备类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * token活跃超时时间
     */
    public Integer getActiveTimeout() {
        return activeTimeout;
    }

    /**
     * token活跃超时时间
     */
    public void setActiveTimeout(Integer activeTimeout) {
        this.activeTimeout = activeTimeout;
    }

    /**
     * token固定超时
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * token固定超时
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
        SysClient other = (SysClient) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getClientKey() == null ? other.getClientKey() == null : this.getClientKey().equals(other.getClientKey()))
            && (this.getClientSecret() == null ? other.getClientSecret() == null : this.getClientSecret().equals(other.getClientSecret()))
            && (this.getGrantType() == null ? other.getGrantType() == null : this.getGrantType().equals(other.getGrantType()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getActiveTimeout() == null ? other.getActiveTimeout() == null : this.getActiveTimeout().equals(other.getActiveTimeout()))
            && (this.getTimeout() == null ? other.getTimeout() == null : this.getTimeout().equals(other.getTimeout()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateDept() == null ? other.getCreateDept() == null : this.getCreateDept().equals(other.getCreateDept()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getClientKey() == null) ? 0 : getClientKey().hashCode());
        result = prime * result + ((getClientSecret() == null) ? 0 : getClientSecret().hashCode());
        result = prime * result + ((getGrantType() == null) ? 0 : getGrantType().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getActiveTimeout() == null) ? 0 : getActiveTimeout().hashCode());
        result = prime * result + ((getTimeout() == null) ? 0 : getTimeout().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDept() == null) ? 0 : getCreateDept().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", clientKey=").append(clientKey);
        sb.append(", clientSecret=").append(clientSecret);
        sb.append(", grantType=").append(grantType);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", activeTimeout=").append(activeTimeout);
        sb.append(", timeout=").append(timeout);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDept=").append(createDept);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}