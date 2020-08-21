package com.ruoyi.budget.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目列表对象 oss_project
 * 
 * @author franplk
 * @date 2020-08-02
 */
public class OssProject extends BaseEntity
{
    private static final Long serialVersionUID = 1L;

    public OssProject() {}

    public OssProject(Integer id) {
        this.id = id;
    }

    public OssProject(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }

    /** 项目ID */
    private Integer id;

    /** 项目编码 */
    @Excel(name = "项目编码")
    private String code;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String name;

    /** 项目经理 */
    @Excel(name = "项目经理")
    private String manager;

    /** 审核人 */
    private String auditor;

    /** 状态（0-新建 1-审核中 2-已完成） */
    @Excel(name = "状态", readConverterExp = "0=-新建,1=-审核中,2=-已完成")
    private Integer status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("manager", getManager())
            .append("auditor", getAuditor())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
