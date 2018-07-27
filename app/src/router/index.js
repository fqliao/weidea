import Vue from 'vue'
import Router from 'vue-router'
import hIndex from '@/components/hospital/index.vue'
import hLogin from '@/components/hospital/login.vue'
import hRecord from '@/components/hospital/record.vue'
import hSaveRecord from '@/components/hospital/saveRecord.vue'
import hSearchRecord from '@/components/hospital/searchRecord.vue'
import pIndex from '@/components/patient/index.vue'
import pLogin from '@/components/patient/login.vue'
import pRegister from '@/components/patient/register.vue'

Vue.use(Router)

export default new Router({
  routes: [
    // 医院
    {
      path: '/',
      name: 'index',
      component: hIndex,
      meta: {
        title: '医链云'
      }
    },
    {
      path: '/hospital-login',
      name: 'login',
      component: hLogin,
      meta: {
        title: '医生登陆'
      }
    },
    {
      path: '/record',
      name: 'record',
      component: hRecord,
      meta: {
        title: '查询病史'
      }
    },
    {
      path: '/saveRecord',
      name: 'saveRecord',
      component: hSaveRecord,
      meta: {
        title: '录入信息'
      }
    },
    {
      path: '/searchRecord',
      name: 'searchRecord',
      component: hSearchRecord,
      meta: {
        title: '医生查询记录'
      }
    },
    // 用户
    {
      path: '/user',
      name: 'user',
      component: pIndex,
      meta: {
        title: '医链云'
      }
    },
    {
      path: '/user-login',
      name: 'login',
      component: pLogin,
      meta: {
        title: '用户登陆'
      }
    },
    {
      path: '/user-register',
      name: 'register',
      component: pRegister,
      meta: {
        title: '用户注册'
      }
    }
  ]
})
