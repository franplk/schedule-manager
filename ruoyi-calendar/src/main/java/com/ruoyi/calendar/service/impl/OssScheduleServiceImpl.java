package com.ruoyi.calendar.service.impl;

import com.ruoyi.calendar.domain.OssSchedule;
import com.ruoyi.calendar.mapper.OssScheduleMapper;
import com.ruoyi.calendar.service.IOssScheduleService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日程Service业务层处理
 *
 * @author franplk
 * @date 2020-08-12
 */
@Service
public class OssScheduleServiceImpl implements IOssScheduleService {
    @Autowired
    private OssScheduleMapper ossScheduleMapper;

    /**
     * 查询日程
     *
     * @param id 日程ID
     * @return 日程
     */
    @Override
    public OssSchedule selectOssScheduleById(Integer id) {
        return ossScheduleMapper.selectOssScheduleById(id);
    }

    /**
     * 查询日程列表
     *
     * @param ossSchedule 日程
     * @return 日程
     */
    @Override
    public List<OssSchedule> selectOssScheduleList(OssSchedule ossSchedule) {
        LoginUser currentUser = SecurityUtils.getLoginUser();
        boolean isAdminRole = false;
        for(SysRole role : currentUser.getUser().getRoles()) {
            if(role.getRoleId() <= 2) {
                isAdminRole = true;
                break;
            }
        }
        if(!isAdminRole) {
            ossSchedule.setCreateBy(currentUser.getUsername());
        }
        return ossScheduleMapper.selectOssScheduleList(ossSchedule);
    }

    /**
     * 新增日程
     *
     * @param ossSchedule 日程
     * @return 结果
     */
    @Override
    public int insertOssSchedule(OssSchedule ossSchedule) {
        LoginUser currentUser = SecurityUtils.getLoginUser();
        ossSchedule.setCreateBy(currentUser.getUsername());
        return ossScheduleMapper.insertOssSchedule(ossSchedule);
    }

    /**
     * 修改日程
     *
     * @param ossSchedule 日程
     * @return 结果
     */
    @Override
    public int updateOssSchedule(OssSchedule ossSchedule) {
        return ossScheduleMapper.updateOssSchedule(ossSchedule);
    }

    /**
     * 批量删除日程
     *
     * @param ids 需要删除的日程ID
     * @return 结果
     */
    @Override
    public int deleteOssScheduleByIds(Integer[] ids) {
        return ossScheduleMapper.deleteOssScheduleByIds(ids);
    }

    /**
     * 删除日程信息
     *
     * @param id 日程ID
     * @return 结果
     */
    @Override
    public int deleteOssScheduleById(Integer id) {
        return ossScheduleMapper.deleteOssScheduleById(id);
    }
}
