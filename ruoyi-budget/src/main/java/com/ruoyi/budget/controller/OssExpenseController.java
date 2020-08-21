package com.ruoyi.budget.controller;

import com.ruoyi.budget.domain.OssExpense;
import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.domain.vo.OssExpenseVO;
import com.ruoyi.budget.service.IOssExpenseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget/expense")
public class OssExpenseController extends BaseController {

    @Autowired
    private IOssExpenseService ossExpenseService;

    @PreAuthorize("@ss.hasPermi('budget:expense:list')")
    @GetMapping("/list")
    public TableDataInfo tableList(OssProject ossProject) {
        startPage();
        List<OssExpenseVO> dataList = ossExpenseService.selectExpenseList(ossProject);
        return getDataTable(dataList);
    }

    @PreAuthorize("@ss.hasPermi('budget:expense:apply')")
    @GetMapping("/apply/{projectId}")
    public AjaxResult applyData(@PathVariable("projectId") Integer projectId) {
        List<OssExpense> detailList = ossExpenseService.selectExpenseDetail(projectId);
        return AjaxResult.success(detailList);
    }
}
