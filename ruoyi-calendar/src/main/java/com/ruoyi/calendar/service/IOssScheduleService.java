package com.ruoyi.calendar.service;

import java.util.List;
import com.ruoyi.calendar.domain.OssSchedule;

/**
 * 日程Service接口
 * 
 * @author franplk
 * @date 2020-08-12
 */
public interface IOssScheduleService 
{
    /**
     * 查询日程
     * 
     * @param id 日程ID
     * @return 日程
     */
    public OssSchedule selectOssScheduleById(Integer id);

    /**
     * 查询日程列表
     * 
     * @param ossSchedule 日程
     * @return 日程集合
     */
    public List<OssSchedule> selectOssScheduleList(OssSchedule ossSchedule);

    /**
     * 新增日程
     * 
     * @param ossSchedule 日程
     * @return 结果
     */
    public int insertOssSchedule(OssSchedule ossSchedule);

    /**
     * 修改日程
     * 
     * @param ossSchedule 日程
     * @return 结果
     */
    public int updateOssSchedule(OssSchedule ossSchedule);

    /**
     * 批量删除日程
     * 
     * @param ids 需要删除的日程ID
     * @return 结果
     */
    public int deleteOssScheduleByIds(Integer[] ids);

    /**
     * 删除日程信息
     * 
     * @param id 日程ID
     * @return 结果
     */
    public int deleteOssScheduleById(Integer id);
}
