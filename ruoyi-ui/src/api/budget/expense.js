import request from '@/utils/request'

// 查询项目预算列表
export function listExpense(query) {
  return request({
    url: '/budget/expense/list',
    method: 'get',
    params: query
  })
};

// 项目预算数据
export function getExpense(projectId) {
  return request({
    url: '/budget/expense/apply/' + projectId,
    method: 'get'
  });
};
