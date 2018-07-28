<template>
  <div id="app">
  	<v-header></v-header>
 		<div class="content" ref="content">
 			<div>
 				<router-view></router-view>
 			</div>
 		</div>
    <!-- <v-footer></v-footer> -->
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
      if (!this.getData('userInfo')) this.$router.push('/login')
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
}
</style>
