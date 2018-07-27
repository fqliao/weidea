<template>
  <div id="app">
  	<v-header></v-header>
 		<div class="content" ref="content">
 			<div>
 				<router-view></router-view>
 			</div>
 		</div>
  </div>
</template>

<script>
import header from '@/components/header.vue'
export default {
  name: 'app',
  components: {
  	'v-header': header
  },
  beforeCreate() {
    if (this.$router.currentRoute.path !== '/login') {
      if (!this.getData('userInfo')) this.$router.push('/login')
    }
  }
}
</script>

<style lang = "scss">
.content {
  margin-top: 5rem;
  @media screen and (max-width: 600px) {
    margin-top: 1rem;
  }
}
</style>
