package com.ruoyi.budget.service;

import java.util.List;
import com.ruoyi.budget.domain.OssProject;

/**
 * 项目Service接口
 * 
 * @author franplk
 * @date 2020-08-02
 */
public interface IOssProjectService 
{
    /**
     * 查询项目
     * 
     * @param id 项目ID
     * @return 项目
     */
    public OssProject selectOssProjectById(Integer id);

    /**
     * 查询项目列表
     * 
     * @param ossProject 项目
     * @return 项目集合
     */
    public List<OssProject> selectOssProjectList(OssProject ossProject);

    /**
     * 新增项目
     * 
     * @param ossProject 项目
     * @return 结果
     */
    public int insertOssProject(OssProject ossProject);

    /**
     * 修改项目
     * 
     * @param ossProject 项目
     * @return 结果
     */
    public int updateOssProject(OssProject ossProject);

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    public int deleteOssProjectByIds(Integer[] ids);

    /**
     * 删除项目信息
     * 
     * @param id 项目ID
     * @return 结果
     */
    public int deleteOssProjectById(Integer id);

    public void startApplyProject(Integer id);
}
