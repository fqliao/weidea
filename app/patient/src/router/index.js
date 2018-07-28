import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index.vue'
import Login from '@/components/login.vue'
import Register from '@/components/register.vue'
import Record from '@/components/record.vue'
import searchRecord from '@/components/searchRecord.vue'
import changeInfo from '@/components/changeInfo.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      meta: {
        title: '医链云'
      }
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: {
        title: '注册'
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        title: '登陆'
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
      path: '/searchRecord',
      name: 'searchRecord',
      component: searchRecord,
      meta: {
        title: '医生记录查询'
      }
    },
    {
      path: '/changeInfo',
      name: 'changeInfo',
      component: changeInfo,
      meta: {
        title: '修改个人信息'
      }
    }
  ]
})
