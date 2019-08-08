import axios from '@/libs/api.request'

export const initIndexData = () => {
  return axios.request({
    url : 'index/initIndexData',
    method : 'get'
  })
}
