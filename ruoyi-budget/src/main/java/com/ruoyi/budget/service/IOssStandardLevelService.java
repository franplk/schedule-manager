package com.ruoyi.budget.service;

import java.util.List;
import com.ruoyi.budget.domain.OssStandardLevel;

/**
 * 人员等级倍率转换Service接口
 * 
 * @author franplk
 * @date 2020-08-05
 */
public interface IOssStandardLevelService 
{
    /**
     * 查询人员等级倍率转换
     * 
     * @param id 人员等级倍率转换ID
     * @return 人员等级倍率转换
     */
    OssStandardLevel selectOssStandardLevelById(Integer id);

    /**
     * 查询人员等级倍率转换列表
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 人员等级倍率转换集合
     */
    List<OssStandardLevel> selectOssStandardLevelList(OssStandardLevel ossStandardLevel);

    /**
     * 新增人员等级倍率转换
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 结果
     */
    int insertOssStandardLevel(OssStandardLevel ossStandardLevel);

    /**
     * 修改人员等级倍率转换
     * 
     * @param ossStandardLevel 人员等级倍率转换
     * @return 结果
     */
    int updateOssStandardLevel(OssStandardLevel ossStandardLevel);

    /**
     * 批量删除人员等级倍率转换
     * 
     * @param ids 需要删除的人员等级倍率转换ID
     * @return 结果
     */
    int deleteOssStandardLevelByIds(Integer[] ids);

    /**
     * 删除人员等级倍率转换信息
     *
     * @param id 人员等级倍率转换ID
     * @return 结果
     */
    int deleteOssStandardLevelById(Integer id);

    /**
     * 删除指定标准下的所有等级
     *
     * @param sid 标准ID
     * @return 结果
     */
    int deleteByParentID(Integer sid);
}
