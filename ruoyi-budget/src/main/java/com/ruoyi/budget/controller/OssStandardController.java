package com.ruoyi.budget.controller;

import com.ruoyi.budget.domain.OssStandard;
import com.ruoyi.budget.service.IOssStandardService;
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
 * 费用标准Controller
 *
 * @author franplk
 * @date 2020-08-05
 */
@RestController
@RequestMapping("/budget/standard")
public class OssStandardController extends BaseController {
    @Autowired
    private IOssStandardService ossStandardService;

    /**
     * 查询费用标准列表
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:list')")
    @GetMapping("/list")
    public TableDataInfo list(OssStandard ossStandard) {
        startPage();
        List<OssStandard> list = ossStandardService.selectOssStandardList(ossStandard);
        return getDataTable(list);
    }

    /**
     * 导出费用标准列表
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:export')")
    @Log(title = "费用标准", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OssStandard ossStandard) {
        List<OssStandard> list = ossStandardService.selectOssStandardList(ossStandard);
        ExcelUtil<OssStandard> util = new ExcelUtil<OssStandard>(OssStandard.class);
        return util.exportExcel(list, "standard");
    }

    /**
     * 获取费用标准详细信息
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(ossStandardService.selectOssStandardById(id));
    }

    /**
     * 新增费用标准
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:add')")
    @Log(title = "费用标准", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OssStandard ossStandard) {
        return toAjax(ossStandardService.insertOssStandard(ossStandard));
    }

    /**
     * 修改费用标准
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:edit')")
    @Log(title = "费用标准", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OssStandard ossStandard) {
        return toAjax(ossStandardService.updateOssStandard(ossStandard));
    }

    /**
     * 删除费用标准
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:remove')")
    @Log(title = "费用标准", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(ossStandardService.deleteOssStandardByIds(ids));
    }
}
