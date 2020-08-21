package com.ruoyi.budget.mapper;

import com.ruoyi.budget.domain.OssExpense;
import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.domain.vo.OssExpenseVO;

import java.util.List;

/**
 * 项目预算费用Mapper接口
 *
 * @author franplk
 * @date 2020-08-02
 */
public interface OssExpenseMapper {
    /**
     * 查询项目列表列表
     *
     * @param ossProject 项目列表
     * @return 项目列表集合
     */
    public List<OssExpenseVO> selectExpenseList(OssProject ossProject);

    /**
     * 查询项目预算列表
     *
     * @param projectId 项目预算
     * @return 项目预算集合
     */
    public List<OssExpense> selectExpenseDetail(Integer projectId);

    /**
     * 新增项目预算
     *
     * @param ossExpense 项目预算
     * @return 结果
     */
    public int insertOssExpense(OssExpense ossExpense);

    /**
     * 修改项目预算
     *
     * @param ossExpense 项目预算
     * @return 结果
     */
    public int updateOssExpense(OssExpense ossExpense);
}

