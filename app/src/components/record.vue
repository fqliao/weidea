<template>
<div class="index">
  <mu-container>
    <mu-form :model="form">
      <mu-form-item>
        <mu-text-field :value="form.idCard" placeholder="身份证号"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-date-input v-model="form.startTime" label="起始时间" label-float full-width></mu-date-input>
      </mu-form-item>
      <mu-form-item>
        <mu-date-input v-model="form.endTime" label="结束时间" label-float full-width></mu-date-input>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.category" placeholder="科室"></mu-text-field>
      </mu-form-item>
      <mu-form-item>
        <mu-text-field :value="form.password" placeholder="密码"></mu-text-field>
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
        startTime: '',
        endTime: '',
        category: '',
        password: ''
      }
    }
	},
  created() {
  },
  methods: {
    submit() {
      this.$http.post('api/record', this.form).then(response => {
        console.log(response.body)
      })
    }
  }
}
</script>

<style lang = "scss">

</style>