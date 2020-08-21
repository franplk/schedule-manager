package com.ruoyi.budget.domain;

import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 项目预算对象 oss_expense
 *
 * @author franplk
 * @date 2020-08-08
 */
public class OssExpense extends TreeEntity {
    private static final long serialVersionUID = 1L;

    public OssExpense() {}

    public OssExpense(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * ID标识
     */
    private Integer id;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 条目ID
     */
    private Integer tpmId;

    /**
     * 条目上级ID
     */
    private Integer tpmPid;

    /**
     * 条目名称
     */
    private String itemName;

    /**
     * 申报金额
     */
    private Double applySum;

    /**
     * 申报数量
     */
    private Double applyNum;

    /**
     * 申报单价
     */
    private Double applyPrice;

    /**
     * 申报因子
     */
    private Double applyFactor;

    /**
     * 审核金额
     */
    private Double auditSum;

    /**
     * 审核数量
     */
    private Double auditNum;

    /**
     * 审核金额
     */
    private Double auditPrice;

    /**
     * 审核因子
     */
    private Double auditFactor;

    /**
     * 备注信息
     */
    private String memo;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setTpmId(Integer tpmId) {
        this.tpmId = tpmId;
    }

    public Integer getTpmId() {
        return tpmId;
    }

    public void setTpmPid(Integer tpmPid) {
        this.tpmPid = tpmPid;
    }

    public Integer getTpmPid() {
        return tpmPid;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setApplySum(Double applySum) {
        this.applySum = applySum;
    }

    public Double getApplySum() {
        return applySum;
    }

    public OssExpense setApplyNum(Double applyNum) {
        this.applyNum = applyNum;
        return this;
    }

    public Double getApplyNum() {
        return applyNum;
    }

    public OssExpense setApplyPrice(Double applyPrice) {
        this.applyPrice = applyPrice;
        return this;
    }

    public Double getApplyPrice() {
        return applyPrice;
    }

    public void setApplyFactor(Double applyFactor) {
        this.applyFactor = applyFactor;
    }

    public Double getApplyFactor() {
        return applyFactor;
    }

    public void setAuditSum(Double auditSum) {
        this.auditSum = auditSum;
    }

    public Double getAuditSum() {
        return auditSum;
    }

    public void setAuditNum(Double auditNum) {
        this.auditNum = auditNum;
    }

    public Double getAuditNum() {
        return auditNum;
    }

    public void setAuditPrice(Double auditPrice) {
        this.auditPrice = auditPrice;
    }

    public Double getAuditPrice() {
        return auditPrice;
    }

    public void setAuditFactor(Double auditFactor) {
        this.auditFactor = auditFactor;
    }

    public Double getAuditFactor() {
        return auditFactor;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }
}