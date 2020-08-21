import request from '@/utils/request'

// 查询费用模板列表
export function listTemplate(query) {
  return request({
    url: '/budget/template/list',
    method: 'get',
    params: query
  })
}

// 查询费用模板详细
export function getTemplate(id) {
  return request({
    url: '/budget/template/' + id,
    method: 'get'
  })
}

// 新增费用模板
export function addTemplate(data) {
  return request({
    url: '/budget/template',
    method: 'post',
    data: data
  })
}

// 修改费用模板
export function updateTemplate(data) {
  return request({
    url: '/budget/template',
    method: 'put',
    data: data
  })
}

// 删除费用模板
export function delTemplate(id) {
  return request({
    url: '/budget/template/' + id,
    method: 'delete'
  })
}

// 导出费用模板
export function exportTemplate(query) {
  return request({
    url: '/budget/template/export',
    method: 'get',
    params: query
  })
}
