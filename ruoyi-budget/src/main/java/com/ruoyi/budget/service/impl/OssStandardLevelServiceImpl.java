package com.ruoyi.budget.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.budget.mapper.OssStandardLevelMapper;
import com.ruoyi.budget.domain.OssStandardLevel;
import com.ruoyi.budget.service.IOssStandardLevelService;

/**
 * 人员等级倍率转换Service业务层处理
 * 
 * @author franplk
 * @date 2020-08-05
 */
@Service
public class OssStandardLevelServiceImpl implements IOssStandardLevelService 
{
    @Autowired
    private OssStandardLevelMapper ossStandardLevelMapper;

    /**
     * 查询人员等级倍率转换
     * 
     * @param id 人员等级倍率转换ID
     * @return 人员等级倍率转换
     */
    @Override
    public OssStandardLevel selectOssStandardLevelById(Integer id)
    {
        return ossStandardLevelMapper.selectOssStandardLevelById(id);
    }

    /**
     * 查询人员等级倍率转换列表
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 人员等级倍率转换
     */
    @Override
    public List<OssStandardLevel> selectOssStandardLevelList(OssStandardLevel ossStandardLevel)
    {
        return ossStandardLevelMapper.selectOssStandardLevelList(ossStandardLevel);
    }

    /**
     * 新增人员等级倍率转换
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 结果
     */
    @Override
    public int insertOssStandardLevel(OssStandardLevel ossStandardLevel)
    {
        return ossStandardLevelMapper.insertOssStandardLevel(ossStandardLevel);
    }

    /**
     * 修改人员等级倍率转换
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 结果
     */
    @Override
    public int updateOssStandardLevel(OssStandardLevel ossStandardLevel)
    {
        return ossStandardLevelMapper.updateOssStandardLevel(ossStandardLevel);
    }

    /**
     * 批量删除人员等级倍率转换
     * 
     * @param ids 需要删除的人员等级倍率转换ID
     * @return 结果
     */
    @Override
    public int deleteOssStandardLevelByIds(Integer[] ids)
    {
        return ossStandardLevelMapper.deleteOssStandardLevelByIds(ids);
    }

    /**
     * 删除人员等级倍率转换信息
     * 
     * @param id 人员等级倍率转换ID
     * @return 结果
     */
    @Override
    public int deleteOssStandardLevelById(Integer id)
    {
        return ossStandardLevelMapper.deleteOssStandardLevelById(id);
    }

    public int deleteByParentID(Integer sid) {
        return ossStandardLevelMapper.deleteByParentID(sid);
    }
}
