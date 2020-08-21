package com.ruoyi.budget.mapper;

import java.util.List;
import com.ruoyi.budget.domain.OssStandard;

/**
 * 费用标准Mapper接口
 * 
 * @author franplk
 * @date 2020-08-05
 */
public interface OssStandardMapper 
{
    /**
     * 查询费用标准
     * 
     * @param id 费用标准ID
     * @return 费用标准
     */
    public OssStandard selectOssStandardById(Integer id);

    /**
     * 查询费用标准列表
     * 
     * @param ossStandard 费用标准
     * @return 费用标准集合
     */
    public List<OssStandard> selectOssStandardList(OssStandard ossStandard);

    /**
     * 新增费用标准
     * 
     * @param ossStandard 费用标准
     * @return 结果
     */
    public int insertOssStandard(OssStandard ossStandard);

    /**
     * 修改费用标准
     * 
     * @param ossStandard 费用标准
     * @return 结果
     */
    public int updateOssStandard(OssStandard ossStandard);

    /**
     * 删除费用标准
     * 
     * @param id 费用标准ID
     * @return 结果
     */
    public int deleteOssStandardById(Integer id);

    /**
     * 批量删除费用标准
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOssStandardByIds(Integer[] ids);
}
