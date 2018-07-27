import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index.vue'
import Login from '@/components/login.vue'
import Record from '@/components/record.vue'
import SaveRecord from '@/components/saveRecord.vue'
import SearchRecord from '@/components/searchRecord.vue'

Vue.use(Router)

export default new Router({
  routes: [
    // 医院
    {
      path: '/',
      name: 'index',
      component: Index,
      meta: {
        title: '医链云'
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        title: '医生登陆'
      }
    },
    {
      path: '/record',
      name: 'record',
      component: Record,
      meta: {
        title: '查询病史'
      }
    },
    {
      path: '/saveRecord',
      name: 'saveRecord',
      component: SaveRecord,
      meta: {
        title: '录入信息'
      }
    },
    {
      path: '/searchRecord',
      name: 'searchRecord',
      component: SearchRecord,
      meta: {
        title: '医生记录查询'
      }
    }
  ]
})
