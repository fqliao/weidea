<template>
<div class="index">
	<mu-flex justify-content="center" class="item">
  	<mu-button large class="btn" @click="goRecord">查询病史</mu-button>
  </mu-flex>
  <mu-flex justify-content="center" class="item">
  	<mu-button large class="btn" @click="goSearchRecord">医生记录查询</mu-button>
  </mu-flex>
  <mu-flex justify-content="center" class="item">
  	<mu-button large class="btn" @click="goChangeInfo">修改个人信息</mu-button>
	</mu-flex>
</div>
</template>

<script>
import bus from '../assets/eventBus.js'
export default {
	name: 'index',
	data() {
		return {
    }
	},
  mounted() {
  	const userInfo = this.getData('userInfo')
  	if (!userInfo) {
      this.$router.push('login')
      return
    }
  	bus.$emit('user', userInfo.name)
		bus.$emit('headerShow', true)
  },
  methods: {
    goRecord() {
    	this.$router.push('/record')
    },
    goSearchRecord() {
    	this.$router.push('/searchRecord')
    },
    goChangeInfo() {
    	this.$router.push('/changeInfo')
    }
  }
}
</script>

<style lang = "scss">
.index {
	margin-top: 2rem;
	.item {
		margin: 1rem 0;
	}
}
</style>