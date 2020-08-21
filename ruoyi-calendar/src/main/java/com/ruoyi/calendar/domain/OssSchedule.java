package com.ruoyi.calendar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 日程对象 oss_schedule
 *
 * @author franplk
 * @date 2020-08-12
 */
public class OssSchedule extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 日程名称
     */
    private String title;

    /**
     * 事件等级
     */
    private String level;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date stopTime;

    /**
     * 是否全天 0-否1-是
     */
    private Integer allday;

    /**
     * 计划人员
     */
    private String planner;

    /**
     * 提交人员
     */
    private String supporter;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setAllday(Integer allday) {
        this.allday = allday;
    }

    public Integer getAllday() {
        return allday;
    }

    public void setPlanner(String planner) {
        this.planner = planner;
    }

    public String getPlanner() {
        return planner;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getSupporter() {
        return supporter;
    }
}
