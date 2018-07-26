<template>
<div class="index">
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
      <mu-form-item label="科室" help-text="" :rules="categoryRules" prop="category">
        <mu-text-field v-model="form.category" prop="category"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="密码" help-text="" :rules="passwordRules" prop="password">
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
import { checkId } from '../assets/common.js' 
export default {
	name: 'record',
	data() {
		return {
      form: {
        idCard: '',
        startTime: undefined,
        endTime: undefined,
        category: '',
        password: ''
      },
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      categoryRules: [{
        validate: (val) => val.length > 0, message: '科室信息为必填项'
      }],
      passwordRules: [{
        validate: (val) => val.length > 6, message: '密码必须大于6位数'
      }],
      startRules: [{
        validate: (val) => val !== undefined, message: '请选择起始时间'
      }],
      endRules: [{
        validate: (val) => val !== undefined, message: '请选择结束时间'
      }]
    }
	},
  created() {
  },
  methods: {
    submit() {
      this.$refs.form.validate().then(res => {
        if (res) {
          let form = Object.assign({}, this.form)
          console.log(form)
          this.$http.post('api/record', form).then(res => {
            console.log(res.body)
          })
        }
      })
          
    }
  }
}
</script>

<style lang = "scss">

</style>