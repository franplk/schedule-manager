package com.ruoyi.budget.service;

import com.ruoyi.budget.domain.OssExpense;
import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.domain.vo.OssExpenseVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目预算费用业务接口
 */
public interface IOssExpenseService {

    public List<OssExpenseVO> selectExpenseList(OssProject ossProject);

    /**
     * 查询项目预算列表
     *
     * @param projectId 项目ID
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
