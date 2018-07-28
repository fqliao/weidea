<template>
<div class="index">
  <img src="../../static/logo.png">
	<mu-flex justify-content="center" class="item">
  <mu-button flat @click="goRecord">
    <mu-icon size="30" class="icon" value="search"></mu-icon>
    查询病历记录
  </mu-button>
  </mu-flex>
  <mu-flex justify-content="center" class="item">
  <mu-button flat @click="goSearchRecord">
    <mu-icon size="30" class="icon" value="assignment"></mu-icon>
    医生记录查询
  </mu-button>
  </mu-flex>
  <mu-flex justify-content="center" class="item">
  <mu-button flat @click="goChangeInfo">
    <mu-icon size="30" class="icon" value="person"></mu-icon>
    修改个人信息
  </mu-button>
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
  img {
    margin: 0 auto;
    width: 80vw;
    display: block;
    padding-top: 2rem;
  }
	.item {
    font-size: 1.4rem;
		margin: 3rem 0;
    vertical-align: middle;
    a {
      font-size: 1.2rem;
    }
    .icon {
      margin-right: .5rem;
    }
	}
}
</style>