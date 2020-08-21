import request from '@/utils/request'

// 查询项目列表列表
export function listProject(query) {
  return request({
    url: '/budget/project/list',
    method: 'get',
    params: query
  })
}

// 查询项目列表详细
export function getProject(id) {
  return request({
    url: '/budget/project/' + id,
    method: 'get'
  })
}

// 新增项目列表
export function addProject(data) {
  return request({
    url: '/budget/project',
    method: 'post',
    data: data
  })
}

// 修改项目列表
export function updateProject(data) {
  return request({
    url: '/budget/project',
    method: 'put',
    data: data
  })
}

// 删除项目列表
export function delProject(id) {
  return request({
    url: '/budget/project/' + id,
    method: 'delete'
  })
}

// 导出项目列表
export function exportProject(query) {
  return request({
    url: '/budget/project/export',
    method: 'get',
    params: query
  })
}

// 设置项目为申报中
export function applyProject(id) {
  return request({
    url: '/budget/project/setApply/' + id, method: 'put'
  });
}

// 项目提交审核
export function submitProject(id) {
  return request({
    url: '/budget/project/setSubmit/' + id, method: 'put'
  });
}

// 项目分配审核人
export function allotProject(id) {
  return request({
    url: '/budget/project/setAllot/' + id, method: 'put'
  });
}

// 项目完成审核
export function finishProject(id, auditor) {
  return request({
    url: '/budget/project/finish/' + id, method: 'post',
    params: {
      'auditor': auditor
    }
  });
}
