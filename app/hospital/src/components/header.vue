<template>
<div class="header" v-show="headerShow">
	<mu-appbar color="primary">
    <mu-avatar slot="left" @click="goIndex">
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

<style lang = "scss">
.header{
	img {
		background-color: #2196f3;
	}
	margin-bottom: 5rem;
	.mu-appbar {
		width: 100%;
		padding: 0 5rem;
	}
	.header-user {
		font-size: 1.2rem;
	}
}
</style>