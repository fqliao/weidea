<template>
<div class="saveRecord">
  <mu-container>
    <mu-form :model="form" ref="form">
      <mu-form-item label="身份证号" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
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
      <mu-form-item label="处方" help-text="" :rules="prescriptionRules" prop="prescription">
        <mu-text-field v-model="form.prescription" prop="prescription"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="记录日期" help-text="" :rules="dateRules" prop="date">
        <mu-date-input v-model="form.date" label-float full-width></mu-date-input>
      </mu-form-item>
      <mu-form-item label="口令" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="form.password" type="password" prop="password"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-button color="primary" @click="submit">录入</mu-button>
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
import { checkId, checkToken } from '../../assets/common.js' 
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
      categoryRules: [{
        validate: (val) => val.length > 0, message: '科室信息为必填项'
      }],
      itemRules: [{
        validate: (val) => val.length > 0, message: '检测项目为必填项'
      }],
      proposalRules: [{
        validate: (val) => val.length > 0, message: '诊断结果为必填项'
      }],
      prescriptionRules: [{
        validate: (val) => val.length > 0, message: '处方为必填项'
      }],
      dateRules: [{
        validate: (val) => val !== undefined, message: '请选择记录日期'
      }],
      passwordRules: [{
        validate: (val) => checkToken(val), message: '口令必须是6位数'
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
          const info = this.getData('hospitalInfo')
          form['hospital'] = info['hospital'] + ',' + info['doctor']
          console.log('req', form)
          this.$http.post('api/saveRecord', form).then(res => {
            if (res.body) {
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