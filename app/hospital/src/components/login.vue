<template>
<div class="login">
	<div class="left">
		<mu-container class="left-contain">
			<mu-flex class="item" justify-content="center">这是一个Demo事例</mu-flex>
			<mu-flex class="item" justify-content="center">医院授权第三方登陆</mu-flex>
			<mu-flex class="item" justify-content="center">拿到医院和医生信息，跳转到我们的管理端首页</mu-flex>
		</mu-container>
	</div>
	<div class="right">
		<mu-form :model="form" ref="form" class="form">
	    <mu-form-item label="医院">
	      <mu-text-field v-model="form.hospital"></mu-text-field>
	    </mu-form-item>
	    <mu-form-item label="医生">
	      <mu-text-field v-model="form.doctor"></mu-text-field>
	    </mu-form-item>
	    <mu-form-item>
	      <mu-button color="primary" @click="goLogin">登陆</mu-button>
	    </mu-form-item>
	  </mu-form>
	</div>
</div>
</template>

<script>
import bus from '../assets/eventBus.js'
export default {
	name: 'login',
	data() {
		return {
			form: {
				hospital: '',
				doctor: ''
			}
		}
	},
	mounted() {
		bus.$emit('headerShow', false)
	},
	methods: {
		goLogin() {
			let form = Object.assign({}, this.form)
			this.setData('hospitalInfo', form)
			this.$router.push('/')
		}
	}
}
</script>

<style lang = "scss">
.login {
	height: 100vh;
	width: 100%;
	display: flex;
	.left {
		flex: 1;
		display: flex;
		align-items: center;
		background-color: #124F95;
		.left-contain {
			color: #eee;
			font-size: 1.2rem;
			.item {
				margin: 1rem 0;
			}
		}
	}
	.right {
		flex: 1;
		display: flex;
		align-items: center;
		.form {
			padding: 0 5rem;
		}
	}
}
</style>