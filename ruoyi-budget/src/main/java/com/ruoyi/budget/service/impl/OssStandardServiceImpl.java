package com.ruoyi.budget.service.impl;

import java.util.List;

import com.ruoyi.budget.mapper.OssStandardLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.budget.mapper.OssStandardMapper;
import com.ruoyi.budget.domain.OssStandard;
import com.ruoyi.budget.service.IOssStandardService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 费用标准Service业务层处理
 * 
 * @author franplk
 * @date 2020-08-05
 */
@Service
public class OssStandardServiceImpl implements IOssStandardService 
{
    @Autowired
    private OssStandardMapper ossStandardMapper;

    @Autowired
    private OssStandardLevelMapper ossStandardLevelMapper;

    /**
     * 查询费用标准
     * 
     * @param id 费用标准ID
     * @return 费用标准
     */
    @Override
    public OssStandard selectOssStandardById(Integer id)
    {
        return ossStandardMapper.selectOssStandardById(id);
    }

    /**
     * 查询费用标准列表
     * 
     * @param ossStandard 费用标准
     * @return 费用标准
     */
    @Override
    public List<OssStandard> selectOssStandardList(OssStandard ossStandard)
    {
        return ossStandardMapper.selectOssStandardList(ossStandard);
    }

    /**
     * 新增费用标准
     * 
     * @param ossStandard 费用标准
     * @return 结果
     */
    @Override
    public int insertOssStandard(OssStandard ossStandard)
    {
        return ossStandardMapper.insertOssStandard(ossStandard);
    }

    /**
     * 修改费用标准
     * 
     * @param ossStandard 费用标准
     * @return 结果
     */
    @Override
    public int updateOssStandard(OssStandard ossStandard)
    {
        return ossStandardMapper.updateOssStandard(ossStandard);
    }

    /**
     * 批量删除费用标准
     * 
     * @param ids 需要删除的费用标准ID
     * @return 结果
     */
    @Override
    public int deleteOssStandardByIds(Integer[] ids)
    {
        return ossStandardMapper.deleteOssStandardByIds(ids);
    }

    /**
     * 删除费用标准信息
     * 
     * @param id 费用标准ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteOssStandardById(Integer id)
    {
        ossStandardLevelMapper.deleteByParentID(id);
        return ossStandardMapper.deleteOssStandardById(id);
    }
}
