import request from '@/utils/request'

// 查询费用标准列表
export function listStandard(query) {
  return request({
    url: '/budget/standard/list',
    method: 'get',
    params: query
  })
}

// 查询费用标准详细
export function getStandard(id) {
  return request({
    url: '/budget/standard/' + id,
    method: 'get'
  })
}

// 新增费用标准
export function addStandard(data) {
  return request({
    url: '/budget/standard',
    method: 'post',
    data: data
  })
}

// 修改费用标准
export function updateStandard(data) {
  return request({
    url: '/budget/standard',
    method: 'put',
    data: data
  })
}

// 删除费用标准
export function delStandard(id) {
  return request({
    url: '/budget/standard/' + id,
    method: 'delete'
  })
}

// 导出费用标准
export function exportStandard(query) {
  return request({
    url: '/budget/standard/export',
    method: 'get',
    params: query
  })
}
