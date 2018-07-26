import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index.vue'
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
