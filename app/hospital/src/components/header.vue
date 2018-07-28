<template>
<div class="header" v-show="headerShow">
	<mu-appbar class="header-contain" color="primary">
    <mu-avatar color="teal" slot="left" @click="goIndex">
    	<img src="../../static/logo.png">
  	</mu-avatar>
	  <p @click="goIndex">医链云</p>
	  <mu-button flat slot="right">
	  	<p class="header-user">{{user}}</p>
	  </mu-button>
	</mu-appbar>
</div>
</template>

<script>
import bus from '../assets/eventBus.js'
export default {
	name: 'Header',
	data() {
		return {
			headerShow: true,
			user: ''
		}
	},
	mounted() {
		bus.$on('user', msg => {
			this.user = msg
		})
		bus.$on('headerShow', msg => {
			this.headerShow = msg
		})
	},
	methods: {
		goIndex() {
			this.$router.push('/')
		}
	}
}
</script>

<style>
.header{
	margin-bottom: 5rem;
	.header-contain {
		width: 100%;
		padding: 0 1rem;
	}
	.header-user {
		font-size: 1.2rem;
	}
}
</style>