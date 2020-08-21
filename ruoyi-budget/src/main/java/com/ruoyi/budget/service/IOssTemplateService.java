package com.ruoyi.budget.service;

import java.util.List;
import com.ruoyi.budget.domain.OssTemplate;

/**
 * 费用模板Service接口
 * 
 * @author franplk
 * @date 2020-08-02
 */
public interface IOssTemplateService 
{
    /**
     * 查询费用模板
     * 
     * @param id 费用模板ID
     * @return 费用模板
     */
    public OssTemplate selectOssTemplateById(Integer id);

    /**
     * 查询费用模板列表
     * 
     * @param ossTemplate 费用模板
     * @return 费用模板集合
     */
    public List<OssTemplate> selectOssTemplateList(OssTemplate ossTemplate);

    /**
     * 新增费用模板
     * 
     * @param ossTemplate 费用模板
     * @return 结果
     */
    public int insertOssTemplate(OssTemplate ossTemplate);

    /**
     * 修改费用模板
     * 
     * @param ossTemplate 费用模板
     * @return 结果
     */
    public int updateOssTemplate(OssTemplate ossTemplate);

    /**
     * 批量删除费用模板
     * 
     * @param ids 需要删除的费用模板ID
     * @return 结果
     */
    public int deleteOssTemplateByIds(Integer[] ids);

    /**
     * 删除费用模板信息
     * 
     * @param id 费用模板ID
     * @return 结果
     */
    public int deleteOssTemplateById(Integer id);
}
