<template>
<div class="register">
  <mu-container>
    <mu-form :model="form" ref="form">
      <mu-form-item label="姓名" help-text="" :rules="usernameRules" prop="userName">
        <mu-text-field v-model="form.userName" prop="userName"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="身份证号" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="手机号" help-text="" :rules="phoneRules" prop="phone">
        <mu-text-field v-model="form.phone" prop="phone"></mu-text-field>
      </mu-form-item>
      <mu-form-item label="口令" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="form.password" type="password" prop="password"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-flex class="select-control-row" :key="'radio ' + i" v-for="(i, item) in sexArr">
          <mu-radio :value="item" v-model="form.sex"  :label="i"></mu-radio>
        </mu-flex>
      </mu-form-item>
      <mu-form-item>
        <mu-button ref="submitButton" color="primary" @click="submit">提交</mu-button>
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
import { checkId, checkPhone } from '../assets/common.js' 
export default {
	name: 'register',
	data() {
		return {
      dialogMsg: '',
      openDialog: false,
      usernameRules: [{
        validate: (val) => val.length > 0, message: '必须填写姓名'
      }],
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      phoneRules: [{
        validate: (val) => checkPhone(val), message: '不是完整的11位手机号或者正确的手机号前七位'
      }],
      passwordRules: [{
        validate: (val) => val.length === 6, message: '口令必须等于6位数'
      }],
      form: {
        userName: '',
        idCard: '',
        phone: '',
        password: '',
        sex: 0
      },
      sexArr: ['女', '男']
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
          this.register(form)
        }
      })
      
    },
    register(head) {
      this.$http.post('api/register', head).then(res => {
        if (res.body.status) {
          this.dialogMsg = '注册成功'
          this.openDialog = true
        } else {
          this.dialogMsg = '注册失败'
          this.openDialog = true
        }
      }, err => {
        console.log(err)
      })
    }
  }
}
</script>

<style lang = "scss">
.mu-demo-form {
  width: 100%;
  max-width: 460px;
}
</style>