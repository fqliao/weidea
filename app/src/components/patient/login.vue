<template>
<div class="patient-login">
  <p>登陆</p>
  <mu-form :model="form" ref="form">
    <mu-form-item label="身份证号" help-text='' :rules="idRules" prop="idCard">
      <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
    </mu-form-item>
    <mu-form-item label="口令" help-text='' :rules="passwordRules" prop="password">
      <mu-text-field v-model="form.password" prop="password"></mu-text-field>
    </mu-form-item>
    <mu-form-item>
      <mu-button color="primary" @click="goLogin">登陆</mu-button>
    </mu-form-item>
  </mu-form>
  <mu-button @click="goRegister">注册</mu-button>
</div>
</template>

<script>
import bus from '../../assets/eventBus.js'
import { checkId, checkToken } from '../../assets/common.js' 
export default {
	name: 'login',
	data() {
		return {
      form: {
        idCard: '',
        password: ''
      },
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      passwordRules: [{
        validate: (val) => checkToken(val), message: '口令必须是6位数'
      }]
    }
	},
  mounted() {
    bus.$emit('headerShow', false)
  },
  methods: {
    goLogin() {
      let form = Object({}, this.form)
      this.$refs.form.validate().then(result => {
        if (result) {
          this.$http.post('api/login', form).then(res => {
            if (res.body) {
              this.$router.push('/user')
            }
          })
        }
      })
    },
    goRegister() {
      this.$router.push('/user-register')
    }
  }
}
</script>

<style lang = "scss">

</style>