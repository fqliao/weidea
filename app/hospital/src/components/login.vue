<template>
<div class="login">
	<div class="left">
		<mu-container class="left-contain">
			<mu-flex class="item" justify-content="center"><img src="../../static/hospital.png"></mu-flex>
			<mu-flex class="item" justify-content="center">这是一个Demo事例</mu-flex>
			<mu-flex class="item" justify-content="center">医院授权第三方登陆</mu-flex>
			<mu-flex class="item" justify-content="center">拿到医院和医生信息，跳转到我们的管理端首页</mu-flex>
		</mu-container>
	</div>
	<div class="right">
		<div>
			<h1>医链云</h1>
			<h3>基于区块链的医疗信息管理系统</h3>
			<mu-form :model="form" ref="form" class="form">
	      <mu-text-field v-model="form.hospital" icon="domain" placeholder="医院"></mu-text-field>
	      <mu-text-field v-model="form.doctor" icon="person" placeholder="医生"></mu-text-field>
		    <mu-flex class="btn">
			    <mu-form-item>
			      <mu-button color="primary" @click="goLogin">登陆</mu-button>
			    </mu-form-item>
		    </mu-flex>
		  </mu-form>
		</div>
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
	img {
		width: 20rem;
	}
	.left {
		flex: .8;
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
		h1 {
			color: #333;
			font-size: 5rem;
			font-weight: 500;
			margin-bottom: -3rem;
		}
		h3 {
			color: #333;
			font-weight: 400;
			font-size: 3rem;
		}
		.btn {
			/*float: right;*/
		}
		flex: 1.2;
		display: flex;
		align-items: center;
		margin-top: -5rem;
		padding: 0 5rem;
	}
}
</style>