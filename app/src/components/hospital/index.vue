<template>
<div class="hospital-index">
  <h1>医链云</h1>
  <h3>基于区块链的医疗信息管理系统</h3>
  <img src="../../../static/logo.png">
  <mu-container class="container-btn">
    <mu-button large class="btn" @click="goRecord">查询病史</mu-button>
    <mu-button large class="btn" @click="goSearchRecord">医生查询记录</mu-button>
    <mu-button large class="btn" @click="goSaveRecord">录入信息</mu-button>
  </mu-container>
</div>
</template>

<script>
import bus from '../../assets/eventBus.js'
export default {
	name: 'index',
	data() {
		return {
    }
	},
  mounted() {
    // 初始化数据
    let info = this.getData('hospitalInfo')
    if (!info) {
      // TODO 弹出，需要登陆...
      this.$router.push('hospital-login')
      return
    }
    bus.$emit('user', info.doctor)
    bus.$emit('headerShow', true)
    bus.$emit('goIndex', () => {
      this.$router.push('/')
    })
  },
  methods: {
    goRecord() {
      this.$router.push('/record')
    },
    goSearchRecord() {
      this.$router.push('/searchRecord')
    },
    goSaveRecord() {
      this.$router.push('/saveRecord')
    }
  }
}
</script>

<style lang = "scss">
.hospital-index {
  margin: 0 1rem;
  text-align: center;
  h1 {
    color: #333;
    font-size: 4rem;
    margin: 2rem 0;
  }
  h3 {
    color: #333;
    font-size: 2rem;
  }
  .container-btn {
    margin-top: 2rem;
    .btn {
      font-size: 1.2rem;
      margin: 0 1rem;
      @media screen and (max-width: 600px) {
        margin: 0;        
      }
    }
  }
}
</style>