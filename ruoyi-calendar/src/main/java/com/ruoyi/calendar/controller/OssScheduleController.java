package com.ruoyi.calendar.controller;

import com.ruoyi.calendar.domain.OssSchedule;
import com.ruoyi.calendar.service.IOssScheduleService;
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
 * 日程Controller
 *
 * @author franplk
 * @date 2020-08-12
 */
@RestController
@RequestMapping("/calendar/schedule")
public class OssScheduleController extends BaseController {
    @Autowired
    private IOssScheduleService ossScheduleService;

    /**
     * 查询日程列表
     */
    @GetMapping("/list")
    public AjaxResult list(OssSchedule ossSchedule) {
        List<OssSchedule> list = ossScheduleService.selectOssScheduleList(ossSchedule);
        return AjaxResult.success(list);
    }

    /**
     * 获取日程详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(ossScheduleService.selectOssScheduleById(id));
    }

    /**
     * 新增日程
     */
    @Log(title = "日程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OssSchedule ossSchedule) {
        return toAjax(ossScheduleService.insertOssSchedule(ossSchedule));
    }

    /**
     * 修改日程
     */
    @Log(title = "日程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OssSchedule ossSchedule) {
        return toAjax(ossScheduleService.updateOssSchedule(ossSchedule));
    }

    /**
     * 删除日程
     */
    @Log(title = "日程", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(ossScheduleService.deleteOssScheduleByIds(ids));
    }
}
