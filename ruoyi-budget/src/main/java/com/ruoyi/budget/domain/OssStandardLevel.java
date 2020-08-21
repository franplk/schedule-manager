package com.ruoyi.budget.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员等级倍率转换对象 oss_standard_level
 * 
 * @author franplk
 * @date 2020-08-05
 */
public class OssStandardLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 标准ID */
    private Integer sid;

    /** 等级编码 */
    @Excel(name = "等级编码")
    private String code;

    /** 等级头衔 */
    @Excel(name = "等级头衔")
    private String title;

    /** 担任角色描述 */
    @Excel(name = "担任角色描述")
    private String roles;

    /** 经验最低年限 */
    @Excel(name = "经验最低年限")
    private Integer minyear;

    /** 换算倍率 */
    @Excel(name = "换算倍率")
    private BigDecimal ratio;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setSid(Integer sid) 
    {
        this.sid = sid;
    }

    public Integer getSid() 
    {
        return sid;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setRoles(String roles) 
    {
        this.roles = roles;
    }

    public String getRoles() 
    {
        return roles;
    }
    public void setMinyear(Integer minyear) 
    {
        this.minyear = minyear;
    }

    public Integer getMinyear() 
    {
        return minyear;
    }
    public void setRatio(BigDecimal ratio) 
    {
        this.ratio = ratio;
    }

    public BigDecimal getRatio() 
    {
        return ratio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sid", getSid())
            .append("code", getCode())
            .append("title", getTitle())
            .append("roles", getRoles())
            .append("minyear", getMinyear())
            .append("ratio", getRatio())
            .toString();
    }
}
