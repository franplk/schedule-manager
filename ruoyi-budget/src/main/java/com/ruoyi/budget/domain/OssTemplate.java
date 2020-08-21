package com.ruoyi.budget.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 费用模板对象 oss_template
 * 
 * @author franplk
 * @date 2020-08-02
 */
public class OssTemplate extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 条目ID */
    private Integer id;

    /** 条目名称 */
    @Excel(name = "条目名称")
    private String name;

    /** 父ID */
    @Excel(name = "父ID")
    private Integer pid;

    /** 模板类型 */
    @Excel(name = "模板类型")
    private Integer tpmType;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPid(Integer pid) 
    {
        this.pid = pid;
    }

    public Integer getPid() 
    {
        return pid;
    }
    public void setTpmType(Integer tpmType) 
    {
        this.tpmType = tpmType;
    }

    public Integer getTpmType() 
    {
        return tpmType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("pid", getPid())
            .append("tpmType", getTpmType())
            .toString();
    }
}
