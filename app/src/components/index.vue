<template>
<div class="index">
  <h1>医链云</h1>
  <h3>基于区块链的医疗信息管理系统</h3>
  <img src="../../static/logo.png">
  <mu-container class="container-btn">
    <mu-button large class="btn" @click="goRecord">查询</mu-button>
    <mu-button large class="btn" @click="goSaveRecord">录入</mu-button>
  </mu-container>
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
.index {
  text-align: center;
  h1 {
    color: #333;
    font-size: 60px;
    margin: 5rem 0;
  }
  h3 {
    color: #333;
    font-size: 36px;
  }
  .container-btn {
    margin-top: 5rem;
    .btn {
      font-size: 18px;
      margin: 0 3rem;
    }
  }
}
</style>