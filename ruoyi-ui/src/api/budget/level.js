import request from '@/utils/request'

// 查询人员等级倍率转换列表
export function listLevel(query) {
  return request({
    url: '/budget/level/list',
    method: 'get',
    params: query
  })
}

// 查询人员等级倍率转换详细
export function getLevel(id) {
  return request({
    url: '/budget/level/' + id,
    method: 'get'
  })
}

// 新增人员等级倍率转换
export function addLevel(data) {
  return request({
    url: '/budget/level',
    method: 'post',
    data: data
  })
}

// 修改人员等级倍率转换
export function updateLevel(data) {
  return request({
    url: '/budget/level',
    method: 'put',
    data: data
  })
}

// 删除人员等级倍率转换
export function delLevel(id) {
  return request({
    url: '/budget/level/' + id,
    method: 'delete'
  })
}

// 导出人员等级倍率转换
export function exportLevel(query) {
  return request({
    url: '/budget/level/export',
    method: 'get',
    params: query
  })
}
