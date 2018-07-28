<template>
	<div class="footer" v-if="footerShow">
		<p>WeBank Star ©2018</p>
	</div>	
</template>

<script>
import bus from '../assets/eventBus.js'
export default {
	name: 'Footer',
	data() {
		return {
			footerShow: false
		}
	},
	mounted() {
		bus.$on('footerShow', msg => {
			console.log(msg)
			this.footerShow = msg
		})
	}
}
</script>

<style>
.footer {
	text-align: center;
	color: #aaa;
}
</style>