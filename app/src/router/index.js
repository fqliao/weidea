import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index.vue'
import Register from '@/components/register.vue'
import Record from '@/components/record.vue'
import saveRecord from '@/components/saveRecord.vue'

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
      path: '/record',
      name: 'record',
      component: Record,
      meta: {
        title: '查询信息'
      }
    },
    {
      path: '/saveRecord',
      name: 'saveRecord',
      component: saveRecord,
      meta: {
        title: '录入信息'
      }
    }
  ]
})
