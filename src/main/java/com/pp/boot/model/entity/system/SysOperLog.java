package com.pp.boot.model.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志记录
 *
 * @TableName sys_oper_log
 */
public class SysOperLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    private Long operId;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer operatorType;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 请求URL
     */
    private String operUrl;

    /**
     * 主机地址
     */
    private String operIp;

    /**
     * 操作地点
     */
    private String operLocation;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 操作时间
     */
    private Date operTime;

    /**
     * 消耗时间
     */
    private Long costTime;

    /**
     * 日志主键
     */
    public Long getOperId() {
        return operId;
    }

    /**
     * 日志主键
     */
    public void setOperId(Long operId) {
        this.operId = operId;
    }

    /**
     * 模块标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 模块标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 方法名称
     */
    public String getMethod() {
        return method;
    }

    /**
     * 方法名称
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 请求方式
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 请求方式
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    public Integer getOperatorType() {
        return operatorType;
    }

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    /**
     * 操作人员
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 操作人员
     */
    public void setOperName(String operName) {
        this.operName = operName;
    }

    /**
     * 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 请求URL
     */
    public String getOperUrl() {
        return operUrl;
    }

    /**
     * 请求URL
     */
    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    /**
     * 主机地址
     */
    public String getOperIp() {
        return operIp;
    }

    /**
     * 主机地址
     */
    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    /**
     * 操作地点
     */
    public String getOperLocation() {
        return operLocation;
    }

    /**
     * 操作地点
     */
    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    /**
     * 请求参数
     */
    public String getOperParam() {
        return operParam;
    }

    /**
     * 请求参数
     */
    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    /**
     * 返回参数
     */
    public String getJsonResult() {
        return jsonResult;
    }

    /**
     * 返回参数
     */
    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    /**
     * 操作状态（0正常 1异常）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 操作状态（0正常 1异常）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 错误消息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 错误消息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 操作时间
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * 操作时间
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * 消耗时间
     */
    public Long getCostTime() {
        return costTime;
    }

    /**
     * 消耗时间
     */
    public void setCostTime(Long costTime) {
        this.costTime = costTime;
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
        SysOperLog other = (SysOperLog) that;
        return (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
                && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
                && (this.getRequestMethod() == null ? other.getRequestMethod() == null : this.getRequestMethod().equals(other.getRequestMethod()))
                && (this.getOperatorType() == null ? other.getOperatorType() == null : this.getOperatorType().equals(other.getOperatorType()))
                && (this.getOperName() == null ? other.getOperName() == null : this.getOperName().equals(other.getOperName()))
                && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
                && (this.getOperUrl() == null ? other.getOperUrl() == null : this.getOperUrl().equals(other.getOperUrl()))
                && (this.getOperIp() == null ? other.getOperIp() == null : this.getOperIp().equals(other.getOperIp()))
                && (this.getOperLocation() == null ? other.getOperLocation() == null : this.getOperLocation().equals(other.getOperLocation()))
                && (this.getOperParam() == null ? other.getOperParam() == null : this.getOperParam().equals(other.getOperParam()))
                && (this.getJsonResult() == null ? other.getJsonResult() == null : this.getJsonResult().equals(other.getJsonResult()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
                && (this.getOperTime() == null ? other.getOperTime() == null : this.getOperTime().equals(other.getOperTime()))
                && (this.getCostTime() == null ? other.getCostTime() == null : this.getCostTime().equals(other.getCostTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getRequestMethod() == null) ? 0 : getRequestMethod().hashCode());
        result = prime * result + ((getOperatorType() == null) ? 0 : getOperatorType().hashCode());
        result = prime * result + ((getOperName() == null) ? 0 : getOperName().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getOperUrl() == null) ? 0 : getOperUrl().hashCode());
        result = prime * result + ((getOperIp() == null) ? 0 : getOperIp().hashCode());
        result = prime * result + ((getOperLocation() == null) ? 0 : getOperLocation().hashCode());
        result = prime * result + ((getOperParam() == null) ? 0 : getOperParam().hashCode());
        result = prime * result + ((getJsonResult() == null) ? 0 : getJsonResult().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getOperTime() == null) ? 0 : getOperTime().hashCode());
        result = prime * result + ((getCostTime() == null) ? 0 : getCostTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operId=").append(operId);
        sb.append(", title=").append(title);
        sb.append(", businessType=").append(businessType);
        sb.append(", method=").append(method);
        sb.append(", requestMethod=").append(requestMethod);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", operName=").append(operName);
        sb.append(", deptName=").append(deptName);
        sb.append(", operUrl=").append(operUrl);
        sb.append(", operIp=").append(operIp);
        sb.append(", operLocation=").append(operLocation);
        sb.append(", operParam=").append(operParam);
        sb.append(", jsonResult=").append(jsonResult);
        sb.append(", status=").append(status);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", operTime=").append(operTime);
        sb.append(", costTime=").append(costTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}