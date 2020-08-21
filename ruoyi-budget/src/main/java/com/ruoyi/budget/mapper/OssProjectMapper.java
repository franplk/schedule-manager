package com.ruoyi.budget.mapper;

import java.util.List;
import com.ruoyi.budget.domain.OssProject;

/**
 * 项目列表Mapper接口
 * 
 * @author franplk
 * @date 2020-08-02
 */
public interface OssProjectMapper 
{
    /**
     * 查询项目列表
     * 
     * @param id 项目列表ID
     * @return 项目列表
     */
    public OssProject selectOssProjectById(Integer id);

    /**
     * 查询项目列表列表
     * 
     * @param ossProject 项目列表
     * @return 项目列表集合
     */
    public List<OssProject> selectOssProjectList(OssProject ossProject);

    /**
     * 新增项目列表
     * 
     * @param ossProject 项目列表
     * @return 结果
     */
    public int insertOssProject(OssProject ossProject);

    /**
     * 修改项目列表
     * 
     * @param ossProject 项目列表
     * @return 结果
     */
    public int updateOssProject(OssProject ossProject);

    /**
     * 删除项目列表
     * 
     * @param id 项目列表ID
     * @return 结果
     */
    public int deleteOssProjectById(Integer id);

    /**
     * 批量删除项目列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOssProjectByIds(Integer[] ids);
}
