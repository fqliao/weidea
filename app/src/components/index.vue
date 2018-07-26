<template>
<div class="index">
  <mu-button @click="goRecord">查询</mu-button>
  <mu-button @click="goSaveRecord">录入</mu-button>
</div>
</template>

<script>
export default {
	name: 'index',
	data() {
		return {
    }
	},
  created() {
  },
  methods: {
    goRecord() {
      this.$router.push('/record')
    },
    goSaveRecord() {
      this.$router.push('/saveRecord')
    }
  }
}
</script>

<style lang = "scss">

</style>