<template>
<div class="index">
  <mu-container>
    <mu-form :model="form">
      <mu-form-item>
        <mu-text-field :value="form.idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.hospital" placeholder="医院"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.category" placeholder="科室"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.item" placeholder="检测项目"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.proposal" placeholder="诊断结果"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-date-input v-model="form.date" label="记录日期" label-float full-width></mu-date-input>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.password" placeholder="输入密码"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-button color="primary" @click="submit">查询</mu-button>
      </mu-form-item>
    </mu-form>
  </mu-container>
</div>
</template>

<script>
export default {
	name: 'record',
	data() {
		return {
      form: {
        idCard: '',
        hospital: '',
        item: '',
        category: '',
        proposal: '',
        date: '',
        password: ''
      }
    }
	},
  created() {
  },
  methods: {
    submit() {
      this.$http.post('api/saveRecord', this.form).then(response => {
        console.log(response.body.status)
      })
    }
  }
}
</script>

<style lang = "scss">

</style>