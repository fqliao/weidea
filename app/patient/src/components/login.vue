<template>
<div class="login">
  <mu-flex justify-content="center">
    <img src="../../static/logo.png" class="logo">
  </mu-flex>
  <mu-flex justify-content="center" class="form" v-if="logShow">
    <mu-form :model="login" ref="login">
      <mu-form-item icon="chrome_reader_mode" help-text='' :rules="idRules" prop="idCard">
        <mu-text-field v-model="login.idCard" prop="idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="person" help-text='' :rules="nameRules" prop="name">
        <mu-text-field v-model="login.name" prop="name" placeholder="姓名"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="lock" help-text='' :rules="passwordRules" prop="password">
        <mu-text-field v-model="login.password" prop="password" type="password" placeholder="密码"></mu-text-field>
      </mu-form-item>
      <mu-form-item class="btn">
        <mu-button full-width color="primary" @click="loginFn">登陆</mu-button>
      </mu-form-item>
      <mu-form-item class="btn">
        <mu-button full-width @click="goRegister">注册</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-flex>
  <mu-flex justify-content="center" class="form" v-else>
    <mu-form :model="register" ref="register">
      <mu-form-item icon="person" help-text="" :rules="nameRules" prop="name">
        <mu-text-field v-model="register.name" prop="name" placeholder="姓名"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="chrome_reader_mode" help-text="" :rules="idRules" prop="idCard">
        <mu-text-field v-model="register.idCard" prop="idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="phone" help-text="" :rules="phoneRules" prop="phone">
        <mu-text-field v-model="register.phone" prop="phone" placeholder="手机号"></mu-text-field>
      </mu-form-item>
      <mu-form-item icon="lock" help-text="" :rules="passwordRules" prop="password">
        <mu-text-field v-model="register.password" type="password" prop="password" placeholder="密码"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-flex justify-content="center" class="select-control-row" :key="'radio ' + i" v-for="(i, item) in sexArr">
          <mu-radio :value="item" v-model="register.sex"  :label="i"></mu-radio>
        </mu-flex>
      </mu-form-item>
      <mu-form-item class="btn">
        <mu-button full-width color="primary" @click="submit">提交</mu-button>
      </mu-form-item>
      <mu-form-item class="btn">
        <mu-button full-width @click="goLogin">登陆</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-flex>
  <!-- alert -->
  <mu-alert class="alert" :color="alertColor" @delete="alertShow = false" delete v-if="alertShow" transition="mu-scale-transition">
    <mu-icon left :value.sync="alertIcon"></mu-icon>{{alertText}}
  </mu-alert>
</div>
</template>

<script>
import bus from '../assets/eventBus.js'
import { checkId, checkToken, checkPhone } from '../assets/common.js' 
export default {
	name: 'login',
	data() {
		return {
      logShow: true,
      alertColor: '',
      alertShow: false,
      alertIcon: '',
      alertText: '',
      login: {
        idCard: '',
        name: '',
        password: ''
      },
      register: {
        name: '',
        idCard: '',
        phone: '',
        password: '',
        sex: 0
      },
      sexArr: ['女', '男'],
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      nameRules: [{
        validate: (val) => val.length > 0, message: '请填写姓名'
      }],
      phoneRules: [{
        validate: (val) => checkPhone(val), message: '不是完整的11位手机号或者正确的手机号前七位'
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
    loginFn() {
      let login = Object.assign({}, this.login)
      this.$refs.login.validate().then(result => {
        if (result) {
          this.$http.post('api/login', login).then(res => {
            if (res.body) {
              this.setData('userInfo', login)
              this.$router.push('/')
            }
          })
        }
      })
    },
    closeDialog () {
      this.openDialog = false
    },
    submit() {
      this.$refs.register.validate().then(result => {
        if (result) {
          let register = Object.assign({}, this.register)
          this.registerFn(register)
        }
      })
      
    },
    goRegister() {
      this.logShow = false
    },
    goLogin() {
      this.logShow = true
    },
    registerFn(head) {
      this.$http.post('api/register', head).then(res => {
        if (res.body) {
          this.alertShow = true
          this.alertIcon = 'check_circle'
          this.alertText = '注册成功'
          this.alertColor = 'success'
          let userInfo = {
            idCard: head.idCard,
            name: head.name,
            password: head.password
          }
          this.setData('userInfo', userInfo)
          this.$router.push('/')
        } else {
          this.alertShow = true
          this.alertIcon = 'priority_high'
          this.alertText = '注册失败'
          this.alertColor = 'warning'
          setTimeout(() => {
            this.alertShow = false
          }, 1000)
        }
      }, err => {
        console.log(err)
      })
    }
  }
}
</script>

<style lang = "scss">
.login {
  .logo {
    margin: 2.5rem;
  }
  height: 100%;
  .form {
    margin: 0 1rem;
    .btn {
      padding: 0 .5rem;
    }
  }
  .select-control-row {
    margin-left: 1rem;
  }
  .alert {
    position: absolute;
    top: 0;
    padding: 1rem;
  }
}
.mu-scale-transition-enter-active,
.mu-scale-transition-leave-active {
  transition: transform .45s cubic-bezier(0.23, 1, 0.32, 1), opacity .45s cubic-bezier(0.23, 1, 0.32, 1);
  backface-visibility: hidden;
}

.mu-scale-transition-enter,
.mu-scale-transition-leave-active {
  transform: scale(0);
  opacity: 0;
}
</style>