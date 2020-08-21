package com.ruoyi.budget.domain.vo;

import java.io.Serializable;

public class OssExpenseVO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String code;
    private String name;
    private String remark;
    private Double applySum;
    private Double auditSum;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getApplySum() {
        return applySum;
    }

    public void setApplySum(Double applySum) {
        this.applySum = applySum;
    }

    public Double getAuditSum() {
        return auditSum;
    }

    public void setAuditSum(Double auditSum) {
        this.auditSum = auditSum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
