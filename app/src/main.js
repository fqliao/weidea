// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import vueResource from 'vue-resource'
import MuseUI from 'muse-ui'
import util from './assets/util.js'
import 'muse-ui/dist/muse-ui.css'


Vue.config.productionTip = false

Vue.use(vueResource)
Vue.use(MuseUI)
Vue.use(util)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})
