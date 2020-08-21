package com.ruoyi.budget.service.impl;

import com.ruoyi.budget.domain.OssExpense;
import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.domain.OssTemplate;
import com.ruoyi.budget.enums.ProjectStatus;
import com.ruoyi.budget.mapper.OssExpenseMapper;
import com.ruoyi.budget.mapper.OssProjectMapper;
import com.ruoyi.budget.mapper.OssTemplateMapper;
import com.ruoyi.budget.service.IOssProjectService;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目列表Service业务层处理
 *
 * @author franplk
 * @date 2020-08-02
 */
@Service
public class OssProjectServiceImpl implements IOssProjectService {
    private static final String TPM_CODE = "P{}";

    @Autowired
    private OssTemplateMapper templateMapper;

    @Autowired
    private OssProjectMapper projectMapper;

    @Autowired
    private OssExpenseMapper expenseMapper;

    /**
     * 查询项目列表
     *
     * @param id 项目列表ID
     * @return 项目列表
     */
    @Override
    public OssProject selectOssProjectById(Integer id) {
        OssProject ossProject = projectMapper.selectOssProjectById(id);
        if (ossProject == null) {
            throw new CustomException("该项目不存在", 1001);
        }
        return ossProject;
    }

    /**
     * 查询项目列表列表
     *
     * @param ossProject 项目列表
     * @return 项目列表
     */
    @Override
    public List<OssProject> selectOssProjectList(OssProject ossProject) {
        return projectMapper.selectOssProjectList(ossProject);
    }

    /**
     * 新增项目
     *
     * @param ossProject 项目
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOssProject(OssProject ossProject) {
        // 新增项目
        String dateStr = DateUtils.dateTimeNow();
        ossProject.setCode(StringUtils.format(TPM_CODE, dateStr));
        ossProject.setStatus(ProjectStatus.NEW_CREATED.getValue());
        ossProject.setCreateTime(DateUtils.getNowDate());
        ossProject.setUpdateTime(DateUtils.getNowDate());
        ossProject.setCreateBy(SecurityUtils.getUsername());
        int affectResult = projectMapper.insertOssProject(ossProject);
        if (affectResult < 1) {
            throw new CustomException("项目创建失败");
        }
        // 对于初次申报的项目根据模板初始化预算数据
        List<OssTemplate> templates = templateMapper.selectOssTemplateList(new OssTemplate());
        templates.forEach(t -> {
            OssExpense expense = new OssExpense(ossProject.getId());
            expense.setTpmId(t.getId());
            expense.setTpmPid(t.getPid());
            expense.setItemName(t.getName());
            expense.setApplyNum(0.00).setAuditNum(0.00);
            expenseMapper.insertOssExpense(expense);
        });
        return affectResult;
    }

    /**
     * 修改项目
     *
     * @param ossProject 项目
     * @return 结果
     */
    @Override
    public int updateOssProject(OssProject ossProject) {
        ossProject.setUpdateBy(SecurityUtils.getUsername());
        ossProject.setUpdateTime(DateUtils.getNowDate());
        return projectMapper.updateOssProject(ossProject);
    }

    /**
     * 批量删除项目
     *
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    @Override
    public int deleteOssProjectByIds(Integer[] ids) {
        return projectMapper.deleteOssProjectByIds(ids);
    }

    /**
     * 删除项目信息
     *
     * @param id 项目ID
     * @return 结果
     */
    @Override
    public int deleteOssProjectById(Integer id) {
        return projectMapper.deleteOssProjectById(id);
    }

    /**
     * 进入项目申报
     *
     * @param id 项目ID
     */
    @Override
    public void startApplyProject(Integer id) {
        OssProject ossProject = this.selectOssProjectById(id);
        if (ossProject.getStatus().equals(ProjectStatus.NEW_CREATED.getValue())) {
            this.updateOssProject(new OssProject(id, ProjectStatus.APPLYING.getValue()));
        } else {
            int applyStatus = ProjectStatus.APPLYING.getValue();
            if (ossProject.getStatus() > applyStatus) {
                throw new CustomException("该状态下不能申报", 1002);
            }
        }
    }
}
