<template>
<div class="index">
  <mu-container>
    <mu-form :model="form">
      <mu-form-item>
        <mu-text-field :value="form.userName" placeholder="姓名"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.phone" placeholder="手机号"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.token" placeholder="创建密码"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-flex class="select-control-row" :key="'radio ' + i" v-for="(i, item) in form.sexArr">
          <mu-radio :value="item" v-model="form.sex"  :label="i"></mu-radio>
        </mu-flex>
      </mu-form-item>
      <mu-form-item>
        <mu-button color="primary" @click="submit">提交</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-container>
</div>
</template>

<script>
export default {
	name: 'index',
	data() {
		return {
      form: {
        userName: '',
        idCard: '',
        phone: '',
        token: '',
        sex: 0,
        sexArr: ['女', '男']
      }
    }
	},
  created() {
  },
  methods: {
    submit() {
      this.register(this.form)
    },
    register(head) {
      this.$http.post('http://localhost:3002/register', head).then(response => {
        if (response.status) {
          // TODO
          console.log('register success')
        } else {

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