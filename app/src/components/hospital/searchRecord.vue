<template>
<div class="hospital-searchRecord">
  <mu-container>
    <mu-form :model="form" ref="form">
      <mu-form-item label="身份证号" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="起始时间" help-text="" :rules="startRules" prop="startTime">
        <mu-date-input v-model="form.startTime" :max-date="form.endTime" label-float full-width prop="startTime"></mu-date-input>
      </mu-form-item>
      <mu-form-item label="结束时间" help-text="" :rules="endRules" prop="endTime">
        <mu-date-input v-model="form.endTime" :min-date="form.startTime" label-float full-width prop="endTime"></mu-date-input>
      </mu-form-item>
      <mu-form-item label="口令" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="form.password" type="password" prop="password"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-button color="primary" @click="submit">查询</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-container>
</div>
</template>

<script>
import { checkId, checkToken } from '../../assets/common.js'
export default {
	name: 'searchRecord',
	data() {
		return {
			form: {
				idCard: '',
				startTime: undefined,
				endTime: undefined,
				password: ''
			},
			idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      startRules: [{
        validate: (val) => val !== undefined, message: '请选择起始时间'
      }],
      endRules: [{
        validate: (val) => val !== undefined, message: '请选择结束时间'
      }],
      passwordRules: [{
        validate: (val) => checkToken(val), message: '口令必须是6位数'
      }]
    }
	},
 methods: {
 	submit() {
 		this.$refs.form.validate().then(result => {
 			if (result) {
 				let form = Object.assign({}, this.form)
 				const info = this.getData('hospitalInfo')
 				form['hospital'] = info['hospital'] + ',' + info['doctor']
 				console.log('req', form)
 				this.$http.post('api/searchRecord', form).then(res => {
 					console.log(res.body.info)
 				})
 			}
 		})
 	}
 }
}
</script>

<style lang = "scss">

</style>