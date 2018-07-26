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
}
</script>

<style>
.content {
  margin-top: 5rem;
}
</style>
