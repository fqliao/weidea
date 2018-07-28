<template>
  <div id="app">
  	<v-header class="header"></v-header>
 		<div class="content" ref="content">
 			<div>
 				<router-view></router-view>
 			</div>
 		</div>
    <v-footer class="footer"></v-footer>
  </div>
</template>

<script>
import header from '@/components/header.vue'
import footer from '@/components/footer.vue'
export default {
  name: 'app',
  components: {
  	'v-header': header,
    'v-footer': footer
  },
  beforeCreate() {
    if (this.$router.currentRoute.path !== '/login') {
      if (!this.getData('hospitalInfo')) this.$router.push('/login')
    }
  }
}
</script>

<style lang = "scss">
html {
  height: 100%;
}
body {
  height: 100%;
}
#app {
  height: 100%;
  display: flex;
  flex-direction: column;
  .header {
    flex: 0 0 auto;
  }
  .content {
    flex: 1 0 auto;
  }
  .footer {
    flex: 0 0 auto;
  }
}
</style>
