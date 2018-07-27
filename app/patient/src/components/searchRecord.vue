<template>
<div class="searchRecord">
  <mu-container>
    <mu-paper>
      <mu-data-table :columns="columns" :sort.sync="sort" @sort-change="handleSortChange" :data.sync="list">
        <template slot-scope="scope">
          <td class="is-center">{{scope.row.date}}</td>
          <td class="is-left">{{scope.row.hospital}}</td>
          <td class="is-left">{{scope.row.hospital}}</td>
          <td class="is-left">{{scope.row.recordHash}}</td>
        </template>
      </mu-data-table>
    </mu-paper>
    <mu-button class="recordBtn" @click="goRecord">返回</mu-button>
  </mu-container>
</div>
</template>

<script>
export default {
	name: 'searchRecord',
	data() {
		return {
			list: [],
      sort: {
        date: '',
        order: 'desc'
      },
      columns: [
        { title: '诊断时间', name: 'date', width: 180, sortable: true},
        { title: '医院', name: 'hospital', width: 180},
        { title: '医生', name: 'hospital', width: 180},
        { title: '诊断详情', name: 'recordHash', width: 180}
      ]
    }
	},
	created() {
		const userInfo = this.getData('userInfo')
		let head = {
			idCard: userInfo.idCard,
			password: userInfo.password
		}
		this.$http.post('api/searchRecord', head).then(res => {
			this.list = res.body.info
		})
	},
	methods: {
	 	handleSortChange ({name, order}) {
      this.list = this.list.sort((a, b) => order === 'asc' ? a[name] - b[name] : b[name] - a[name]);
    }
	}
}
</script>

<style lang = "scss">

</style>