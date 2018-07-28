<template>
<div class="saveRecord">
  <mu-container>
    <mu-form :model="form" ref="form" class="form">
      <mu-form-item icon="chrome_reader_mode" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="form.idCard" prop="idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <div class="form-contain">
        <mu-form-item class="form-item" icon="library_books" help-text="" :rules="categoryRules" prop="category">
          <mu-text-field v-model="form.category" prop="category" placeholder="科室"></mu-text-field>
        </mu-form-item>
        <mu-form-item class="form-item" icon="dashboard" help-text="" :rules="itemRules" prop="item">
          <mu-text-field v-model="form.item" prop="item" placeholder="检测项目"></mu-text-field>
        </mu-form-item>
      </div>
      <mu-form-item icon="class" help-text="" :rules="proposalRules" prop="proposal">
        <mu-text-field v-model="form.proposal" prop="proposal" placeholder="诊断结果"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="subject" help-text="" :rules="diagnosisRules" prop="diagnosis">
        <mu-text-field v-model="form.diagnosis" prop="diagnosis" placeholder="处方"></mu-text-field>
      </mu-form-item>
      <!-- <mu-form-item icon="update" help-text="" :rules="dateRules" prop="date" label="记录日期" :label-float="true">
        <mu-date-input v-model="form.date" label-float full-width prop="date"></mu-date-input>
      </mu-form-item> -->
      <mu-form-item icon="lock" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="form.password" type="password" prop="password" placeholder="口令"></mu-text-field>
      </mu-form-item>
      <mu-form-item class="btn">
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
import { checkId, checkToken } from '../assets/common.js' 
export default {
	name: 'record',
	data() {
		return {
      dialogMsg: '',
      openDialog: false,
      form: {
        idCard: '',
        diagnosis: '',
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
      diagnosisRules: [{
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
          const date = new Date()
          form['date'] = date
          console.log('req', form)
          this.$http.post('api/saveRecord', form).then(res => {
            if (res.body) {
              this.dialogMsg = '病历录入成功'
              this.openDialog = true
              this.form = {}
            } else {
              this.dialogMsg = '病历录入失败'
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
.form {
  padding: 0 3rem;
}
.form-contain {
  display: flex;
  .form-item {
    flex: 1;
  }
}
</style>