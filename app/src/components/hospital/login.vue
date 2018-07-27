<template>
<div class="hospital-login">
	<mu-form :model="form" ref="form">
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
</template>

<script>
import bus from '../../assets/eventBus.js'
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

<style>
	
</style>