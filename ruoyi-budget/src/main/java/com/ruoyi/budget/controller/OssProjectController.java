package com.ruoyi.budget.controller;

import com.ruoyi.budget.domain.OssProject;
import com.ruoyi.budget.enums.ProjectStatus;
import com.ruoyi.budget.service.IOssProjectService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目列表Controller
 *
 * @author franplk
 * @date 2020-08-02
 */
@RestController
@RequestMapping("/budget/project")
public class OssProjectController extends BaseController {
    @Autowired
    private IOssProjectService ossProjectService;

    /**
     * 查询项目列表
     */
    @PreAuthorize("@ss.hasPermi('budget:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(OssProject ossProject) {
        startPage();
        List<OssProject> list = ossProjectService.selectOssProjectList(ossProject);
        return getDataTable(list);
    }

    /**
     * 导出项目
     */
    @PreAuthorize("@ss.hasPermi('budget:project:export')")
    @Log(title = "项目列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OssProject ossProject) {
        List<OssProject> list = ossProjectService.selectOssProjectList(ossProject);
        ExcelUtil<OssProject> util = new ExcelUtil<>(OssProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 获取项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('budget:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(ossProjectService.selectOssProjectById(id));
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('budget:project:add')")
    @Log(title = "项目列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OssProject ossProject) {
        return toAjax(ossProjectService.insertOssProject(ossProject));
    }

    /**
     * 修改项目
     */
    @PreAuthorize("@ss.hasPermi('budget:project:edit')")
    @Log(title = "项目列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OssProject ossProject) {
        return toAjax(ossProjectService.updateOssProject(ossProject));
    }

    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('budget:project:remove')")
    @Log(title = "项目列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(ossProjectService.deleteOssProjectByIds(ids));
    }

    /**
     * 项目设置为申报中
     */
    @PreAuthorize("@ss.hasPermi('budget:expense:apply')")
    @Log(title = "项目开始申报", businessType = BusinessType.OTHER)
    @PutMapping("/setApply/{id}")
    public AjaxResult startApply(@PathVariable Integer id) {
        ossProjectService.startApplyProject(id);
        return AjaxResult.success();
    }

    /**
     * 项目提交审核
     */
    @PreAuthorize("@ss.hasPermi('budget:expense:submit')")
    @Log(title = "项目提交审核", businessType = BusinessType.OTHER)
    @PutMapping("/setSubmit/{id}")
    public AjaxResult submitToAudit(@PathVariable Integer id) {
        OssProject ossProject = new OssProject(id);
        ossProject.setStatus(ProjectStatus.ALLOTTING.getValue());
        return toAjax(ossProjectService.updateOssProject(ossProject));
    }

    /**
     * 项目分配审核人
     */
    @PreAuthorize("@ss.hasPermi('budget:expense:allot')")
    @Log(title = "项目分配审核人", businessType = BusinessType.OTHER)
    @PutMapping("/setAllot/{id}")
    public AjaxResult allotAuditor(@PathVariable Integer id) {
        OssProject ossProject = new OssProject(id);
        ossProject.setStatus(ProjectStatus.PRE_AUDIT.getValue());
        return toAjax(ossProjectService.updateOssProject(ossProject));
    }

    /**
     * 项目设置为审核中
     */
    @PreAuthorize("@ss.hasPermi('budget:expense:audit')")
    @Log(title = "项目分配审核人", businessType = BusinessType.OTHER)
    @PutMapping("/setAudit/{id}")
    public AjaxResult startAudit(@PathVariable Integer id) {
        OssProject ossProject = new OssProject(id);
        ossProject.setStatus(ProjectStatus.AUDITING.getValue());
        return toAjax(ossProjectService.updateOssProject(ossProject));
    }

    /**
     * 项目完成审核
     */
    @PreAuthorize("@ss.hasPermi('budget:expense:finish')")
    @Log(title = "项目完成审核", businessType = BusinessType.OTHER)
    @PutMapping("/setFinish/{id}")
    public AjaxResult finishAudit(@PathVariable Integer id) {
        OssProject ossProject = new OssProject(id);
        ossProject.setStatus(ProjectStatus.FINISHED.getValue());
        return toAjax(ossProjectService.updateOssProject(ossProject));
    }
}
