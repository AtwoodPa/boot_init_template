package com.pp.boot.model.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 对象存储配置表
 *
 * @TableName sys_oss_config
 */
public class SysOssConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主建
     */
    private Long ossConfigId;

    /**
     * 配置key
     */
    private String configKey;

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 访问站点
     */
    private String endpoint;

    /**
     * 自定义域名
     */
    private String domain;

    /**
     * 是否https（Y=是,N=否）
     */
    private String isHttps;

    /**
     * 域
     */
    private String region;

    /**
     * 桶权限类型(0=private 1=public 2=custom)
     */
    private String accessPolicy;

    /**
     * 是否默认（0=是,1=否）
     */
    private String status;

    /**
     * 扩展字段
     */
    private String ext1;

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
     * 主建
     */
    public Long getOssConfigId() {
        return ossConfigId;
    }

    /**
     * 主建
     */
    public void setOssConfigId(Long ossConfigId) {
        this.ossConfigId = ossConfigId;
    }

    /**
     * 配置key
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 配置key
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * accessKey
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * 秘钥
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 秘钥
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * 桶名称
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * 桶名称
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 前缀
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 访问站点
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * 访问站点
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 自定义域名
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 自定义域名
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 是否https（Y=是,N=否）
     */
    public String getIsHttps() {
        return isHttps;
    }

    /**
     * 是否https（Y=是,N=否）
     */
    public void setIsHttps(String isHttps) {
        this.isHttps = isHttps;
    }

    /**
     * 域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 域
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 桶权限类型(0=private 1=public 2=custom)
     */
    public String getAccessPolicy() {
        return accessPolicy;
    }

    /**
     * 桶权限类型(0=private 1=public 2=custom)
     */
    public void setAccessPolicy(String accessPolicy) {
        this.accessPolicy = accessPolicy;
    }

    /**
     * 是否默认（0=是,1=否）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 是否默认（0=是,1=否）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 扩展字段
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 扩展字段
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
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
        SysOssConfig other = (SysOssConfig) that;
        return (this.getOssConfigId() == null ? other.getOssConfigId() == null : this.getOssConfigId().equals(other.getOssConfigId()))
                && (this.getConfigKey() == null ? other.getConfigKey() == null : this.getConfigKey().equals(other.getConfigKey()))
                && (this.getAccessKey() == null ? other.getAccessKey() == null : this.getAccessKey().equals(other.getAccessKey()))
                && (this.getSecretKey() == null ? other.getSecretKey() == null : this.getSecretKey().equals(other.getSecretKey()))
                && (this.getBucketName() == null ? other.getBucketName() == null : this.getBucketName().equals(other.getBucketName()))
                && (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
                && (this.getEndpoint() == null ? other.getEndpoint() == null : this.getEndpoint().equals(other.getEndpoint()))
                && (this.getDomain() == null ? other.getDomain() == null : this.getDomain().equals(other.getDomain()))
                && (this.getIsHttps() == null ? other.getIsHttps() == null : this.getIsHttps().equals(other.getIsHttps()))
                && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
                && (this.getAccessPolicy() == null ? other.getAccessPolicy() == null : this.getAccessPolicy().equals(other.getAccessPolicy()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
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
        result = prime * result + ((getOssConfigId() == null) ? 0 : getOssConfigId().hashCode());
        result = prime * result + ((getConfigKey() == null) ? 0 : getConfigKey().hashCode());
        result = prime * result + ((getAccessKey() == null) ? 0 : getAccessKey().hashCode());
        result = prime * result + ((getSecretKey() == null) ? 0 : getSecretKey().hashCode());
        result = prime * result + ((getBucketName() == null) ? 0 : getBucketName().hashCode());
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
        result = prime * result + ((getEndpoint() == null) ? 0 : getEndpoint().hashCode());
        result = prime * result + ((getDomain() == null) ? 0 : getDomain().hashCode());
        result = prime * result + ((getIsHttps() == null) ? 0 : getIsHttps().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getAccessPolicy() == null) ? 0 : getAccessPolicy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
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
        sb.append(", ossConfigId=").append(ossConfigId);
        sb.append(", configKey=").append(configKey);
        sb.append(", accessKey=").append(accessKey);
        sb.append(", secretKey=").append(secretKey);
        sb.append(", bucketName=").append(bucketName);
        sb.append(", prefix=").append(prefix);
        sb.append(", endpoint=").append(endpoint);
        sb.append(", domain=").append(domain);
        sb.append(", isHttps=").append(isHttps);
        sb.append(", region=").append(region);
        sb.append(", accessPolicy=").append(accessPolicy);
        sb.append(", status=").append(status);
        sb.append(", ext1=").append(ext1);
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