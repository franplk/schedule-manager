package com.ruoyi.budget.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.budget.mapper.OssTemplateMapper;
import com.ruoyi.budget.domain.OssTemplate;
import com.ruoyi.budget.service.IOssTemplateService;

/**
 * 费用模板Service业务层处理
 * 
 * @author franplk
 * @date 2020-08-02
 */
@Service
public class OssTemplateServiceImpl implements IOssTemplateService 
{
    @Autowired
    private OssTemplateMapper ossTemplateMapper;

    /**
     * 查询费用模板
     * 
     * @param id 费用模板ID
     * @return 费用模板
     */
    @Override
    public OssTemplate selectOssTemplateById(Integer id)
    {
        return ossTemplateMapper.selectOssTemplateById(id);
    }

    /**
     * 查询费用模板列表
     * 
     * @param ossTemplate 费用模板
     * @return 费用模板
     */
    @Override
    public List<OssTemplate> selectOssTemplateList(OssTemplate ossTemplate)
    {
        return ossTemplateMapper.selectOssTemplateList(ossTemplate);
    }

    /**
     * 新增费用模板
     * 
     * @param ossTemplate 费用模板
     * @return 结果
     */
    @Override
    public int insertOssTemplate(OssTemplate ossTemplate)
    {
        return ossTemplateMapper.insertOssTemplate(ossTemplate);
    }

    /**
     * 修改费用模板
     * 
     * @param ossTemplate 费用模板
     * @return 结果
     */
    @Override
    public int updateOssTemplate(OssTemplate ossTemplate)
    {
        return ossTemplateMapper.updateOssTemplate(ossTemplate);
    }

    /**
     * 批量删除费用模板
     * 
     * @param ids 需要删除的费用模板ID
     * @return 结果
     */
    @Override
    public int deleteOssTemplateByIds(Integer[] ids)
    {
        return ossTemplateMapper.deleteOssTemplateByIds(ids);
    }

    /**
     * 删除费用模板信息
     * 
     * @param id 费用模板ID
     * @return 结果
     */
    @Override
    public int deleteOssTemplateById(Integer id)
    {
        return ossTemplateMapper.deleteOssTemplateById(id);
    }
}
