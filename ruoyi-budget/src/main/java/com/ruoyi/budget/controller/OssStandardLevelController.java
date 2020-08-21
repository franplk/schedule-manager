package com.ruoyi.budget.controller;

import com.ruoyi.budget.domain.OssStandardLevel;
import com.ruoyi.budget.service.IOssStandardLevelService;
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
 * 人员等级倍率转换Controller
 *
 * @author franplk
 * @date 2020-08-05
 */
@RestController
@RequestMapping("/budget/level")
public class OssStandardLevelController extends BaseController {
    @Autowired
    private IOssStandardLevelService ossStandardLevelService;

    /**
     * 查询人员等级倍率转换列表
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:list')")
    @GetMapping("/list")
    public TableDataInfo list(OssStandardLevel ossStandardLevel) {
        startPage();
        List<OssStandardLevel> list = ossStandardLevelService.selectOssStandardLevelList(ossStandardLevel);
        return getDataTable(list);
    }

    /**
     * 导出人员等级倍率转换列表
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:export')")
    @Log(title = "人员等级倍率转换", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(OssStandardLevel ossStandardLevel) {
        List<OssStandardLevel> list = ossStandardLevelService.selectOssStandardLevelList(ossStandardLevel);
        ExcelUtil<OssStandardLevel> util = new ExcelUtil<>(OssStandardLevel.class);
        return util.exportExcel(list, "level");
    }

    /**
     * 获取人员等级倍率转换详细信息
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(ossStandardLevelService.selectOssStandardLevelById(id));
    }

    /**
     * 新增人员等级倍率转换
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:add')")
    @Log(title = "人员等级倍率转换", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OssStandardLevel ossStandardLevel) {
        return toAjax(ossStandardLevelService.insertOssStandardLevel(ossStandardLevel));
    }

    /**
     * 修改人员等级倍率转换
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:edit')")
    @Log(title = "人员等级倍率转换", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OssStandardLevel ossStandardLevel) {
        return toAjax(ossStandardLevelService.updateOssStandardLevel(ossStandardLevel));
    }

    /**
     * 删除人员等级倍率转换
     */
    @PreAuthorize("@ss.hasPermi('budget:standard:remove')")
    @Log(title = "人员等级倍率转换", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(ossStandardLevelService.deleteOssStandardLevelByIds(ids));
    }
}
