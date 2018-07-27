<template>
	<div>
		<p>修改手机号</p>
		<mu-form :model="form" ref="form">
	    <mu-form-item label="手机号" help-text="" :rules="phoneRules" prop="phone">
	      <mu-text-field v-model="form.phone" prop="phone"></mu-text-field>
	    </mu-form-item>
	    <mu-form-item>
	      <mu-button ref="submitButton" color="primary" @click="submit">确认</mu-button>
	      <mu-button ref="submitButton" color="primary" @click="cancel">取消</mu-button>
	    </mu-form-item>
	  </mu-form>
	</div>
</template>

<script>
import { checkPhone } from '../assets/common.js'
export default {
	name: 'changeInfo',
	data() {
		return {
			form: {
				phone: ''
			},
			phoneRules: [{
	      validate: (val) => checkPhone(val), message: '不是完整的11位手机号或者正确的手机号前七位'
	    }]
		}
	},
	methods: {
		submit() {
			alert('确认')
		},
		cancel() {

		}
	}
}
</script>

<style>
	
</style>