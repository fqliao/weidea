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
      component: Index
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/record',
      name: 'record',
      component: Record
    },
    {
      path: '/saveRecord',
      name: 'saveRecord',
      component: saveRecord
    }
  ]
})
