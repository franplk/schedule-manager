package com.ruoyi.budget.controller;

import com.ruoyi.budget.domain.OssTemplate;
import com.ruoyi.budget.service.IOssTemplateService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 费用模板Controller
 *
 * @author franplk
 * @date 2020-08-02
 */
@RestController
@RequestMapping("/budget/template")
public class OssTemplateController extends BaseController {
    @Autowired
    private IOssTemplateService ossTemplateService;

    /**
     * 查询费用模板列表
     */
    @PreAuthorize("@ss.hasPermi('budget:template:list')")
    @GetMapping("/list")
    public AjaxResult list(OssTemplate ossTemplate) {
        List<OssTemplate> list = ossTemplateService.selectOssTemplateList(ossTemplate);
        return AjaxResult.success(list);
    }

    /**
     * 导出费用模板列表
     */
    @PreAuthorize("@ss.hasPermi('budget:template:export')")
    @Log(title = "费用模板", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OssTemplate ossTemplate) {
        List<OssTemplate> list = ossTemplateService.selectOssTemplateList(ossTemplate);
        ExcelUtil<OssTemplate> util = new ExcelUtil<OssTemplate>(OssTemplate.class);
        return util.exportExcel(list, "template");
    }

    /**
     * 获取费用模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('budget:template:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(ossTemplateService.selectOssTemplateById(id));
    }

    /**
     * 新增费用模板
     */
    @PreAuthorize("@ss.hasPermi('budget:template:add')")
    @Log(title = "费用模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OssTemplate ossTemplate) {
        return toAjax(ossTemplateService.insertOssTemplate(ossTemplate));
    }

    /**
     * 修改费用模板
     */
    @PreAuthorize("@ss.hasPermi('budget:template:edit')")
    @Log(title = "费用模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OssTemplate ossTemplate) {
        return toAjax(ossTemplateService.updateOssTemplate(ossTemplate));
    }

    /**
     * 删除费用模板
     */
    @PreAuthorize("@ss.hasPermi('budget:template:remove')")
    @Log(title = "费用模板", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(ossTemplateService.deleteOssTemplateByIds(ids));
    }
}
