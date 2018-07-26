<template>
<div class="header">
	<mu-appbar class="header-contain" color="primary">
    <mu-avatar color="teal" slot="left" @click="goIndex">
    	<img src="../../static/logo.png">
  	</mu-avatar>
	  <p @click="goIndex">医链云</p>
	  <mu-button flat slot="right" @click="goRegister">
	  	<p class="header-register">注册</p>
	  </mu-button>
	</mu-appbar>
</div>
</template>

<script>
export default {
	name: 'Header',
	methods: {
		goRegister() {
			this.$router.push('/register')
		},
		goIndex() {
			this.$router.push('/')
		}
	}
}
</script>

<style>
	.header-contain {
		width: 100%;
		padding: 0 3rem;
	}
	.header-register {
		font-size: 18px;
	}
</style>