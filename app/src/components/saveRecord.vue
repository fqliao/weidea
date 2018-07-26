<template>
<div class="index">
  <mu-container>
    <mu-form :model="form" ref="form">
      <mu-form-item label="身份证号" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="医院" help-text="" :rules="hospitalRules" prop="hospital">
        <mu-text-field v-model="form.hospital" prop="hospital"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="科室" help-text="" :rules="categoryRules" prop="category">
        <mu-text-field v-model="form.category" prop="category"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="检测项目" help-text="" :rules="itemRules" prop="item">
        <mu-text-field v-model="form.item" prop="item"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="诊断结果" help-text="" :rules="proposalRules" prop="proposal">
        <mu-text-field v-model="form.proposal" prop="proposal"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="记录日期" help-text="" :rules="dateRules" prop="date">
        <mu-date-input v-model="form.date" label-float full-width></mu-date-input>
      </mu-form-item>
      <mu-form-item label="密码" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="form.password" type="password" prop="password"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-button color="primary" @click="submit">查询</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-container>
  <mu-dialog title="" width="400" :open.sync="openDialog">
    {{dialogMsg}}
    <mu-button slot="actions" flat color="primary" @click="closeDialog">关闭</mu-button>
  </mu-dialog>
</div>
</template>

<script>
import { checkId } from '../assets/common.js' 
export default {
	name: 'record',
	data() {
		return {
      dialogMsg: '',
      openDialog: false,
      form: {
        idCard: '',
        hospital: '',
        item: '',
        category: '',
        proposal: '',
        date: '',
        password: ''
      },
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      hospitalRules: [{
        validate: (val) => val.length > 0, message: '医院为必填项'
      }],
      categoryRules: [{
        validate: (val) => val.length > 0, message: '科室信息为必填项'
      }],
      itemRules: [{
        validate: (val) => val.length > 0, message: '检测项目为必填项'
      }],
      proposalRules: [{
        validate: (val) => val.length > 0, message: '诊断结果为必填项'
      }],
      dateRules: [{
        validate: (val) => val !== undefined, message: '请选择记录日期'
      }],
      passwordRules: [{
        validate: (val) => val.length > 6, message: '密码必须大于6位数'
      }]
    }
	},
  created() {
  },
  methods: {
    closeDialog () {
      this.openDialog = false
    },
    submit() {
      this.$refs.form.validate().then(result => {
        if (result) {
          let form = Object.assign({}, this.form)
          this.$http.post('api/saveRecord', form).then(res => {
            if (res.body.status) {
              this.dialogMsg = '上链成功'
              this.openDialog = true
            } else {
              this.dialogMsg = '上链失败'
              this.openDialog = true
            }
          })
        }
      })
          
    }
  }
}
</script>

<style lang = "scss">

</style>