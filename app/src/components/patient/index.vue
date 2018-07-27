<template>
<div class="patient-index">
  
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
    bus.$emit('user', 'xxx')
    bus.$emit('headerShow', true)
  },
  methods: {
    
  }
}
</script>

<style lang = "scss">

</style>