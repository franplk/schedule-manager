package com.ruoyi.budget.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用标准对象 oss_standard
 * 
 * @author franplk
 * @date 2020-08-05
 */
public class OssStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 标准分类名称 */
    @Excel(name = "标准分类名称")
    private String name;

    /** 基础标准 */
    @Excel(name = "基础标准")
    private String category;

    /** 标准值 */
    @Excel(name = "标准值")
    private Integer criterion;

    /** 基准值 */
    @Excel(name = "基准值")
    private Integer benchmark;

    /** 参考值 */
    @Excel(name = "参考值")
    private BigDecimal reference;

    /** 模板类型 */
    @Excel(name = "模板类型")
    private Integer tpmtype;

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
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setCriterion(Integer criterion) 
    {
        this.criterion = criterion;
    }

    public Integer getCriterion() 
    {
        return criterion;
    }
    public void setBenchmark(Integer benchmark) 
    {
        this.benchmark = benchmark;
    }

    public Integer getBenchmark() 
    {
        return benchmark;
    }
    public void setReference(BigDecimal reference) 
    {
        this.reference = reference;
    }

    public BigDecimal getReference() 
    {
        return reference;
    }
    public void setTpmtype(Integer tpmtype) 
    {
        this.tpmtype = tpmtype;
    }

    public Integer getTpmtype() 
    {
        return tpmtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("category", getCategory())
            .append("criterion", getCriterion())
            .append("benchmark", getBenchmark())
            .append("reference", getReference())
            .append("tpmtype", getTpmtype())
            .toString();
    }
}
