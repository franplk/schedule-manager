package com.ruoyi.budget.service.impl;

import com.ruoyi.budget.domain.OssExpense;
import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.domain.vo.OssExpenseVO;
import com.ruoyi.budget.mapper.OssExpenseMapper;
import com.ruoyi.budget.service.IOssExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OssExpenseServiceImpl implements IOssExpenseService {

    @Autowired
    private OssExpenseMapper ossExpenseMapper;

    @Override
    public List<OssExpenseVO> selectExpenseList(OssProject ossProject) {
        return ossExpenseMapper.selectExpenseList(ossProject);
    }

    /**
     * 查询项目预算列表
     *
     * @param projectId 项目ID
     * @return 项目预算
     */
    @Override
    public List<OssExpense> selectExpenseDetail(Integer projectId) {
        return ossExpenseMapper.selectExpenseDetail(projectId);
    }

    /**
     * 新增项目预算
     *
     * @param ossExpense 项目预算
     * @return 结果
     */
    @Override
    public int insertOssExpense(OssExpense ossExpense) {
        return ossExpenseMapper.insertOssExpense(ossExpense);
    }

    /**
     * 修改项目预算
     *
     * @param ossExpense 项目预算
     * @return 结果
     */
    @Override
    public int updateOssExpense(OssExpense ossExpense) {
        return ossExpenseMapper.updateOssExpense(ossExpense);
    }
}
