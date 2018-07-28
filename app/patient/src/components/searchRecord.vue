<template>
<div class="searchRecord">
  <mu-container>
    <mu-button class="recordBtn" @click="goIndex">返回</mu-button>
    <mu-paper>
      <mu-data-table :columns="columns" :sort.sync="sort" @sort-change="handleSortChange" :data.sync="list">
        <template slot-scope="scope">
          <td class="is-center">{{scope.row.date}}</td>
          <td class="is-left">{{scope.row.hospital}}</td>
          <td class="is-left">{{scope.row.doctor}}</td>
          <td class="is-left">{{scope.row.recordHash}}</td>
        </template>
      </mu-data-table>
    </mu-paper>
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
        { title: '诊断时间', name: 'date', width: 120, sortable: true},
        { title: '医院', name: 'hospital', width: 120},
        { title: '医生', name: 'doctor', width: 120},
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
      let infos = res.body.infos
      for (let info of infos) {
        let hs = info['hospital'].split(',')
        info['hospital'] = hs[0]
        info['doctor'] = hs[1]
      }
			this.list = infos
		})
	},
	methods: {
	 	handleSortChange ({name, order}) {
      this.list = this.list.sort((a, b) => order === 'asc' ? a[name] - b[name] : b[name] - a[name]);
    },
    goIndex() {
      this.$router.push('/')
    }
	}
}
</script>

<style lang = "scss">
.searchRecord {
  margin: 1rem;
  .recordBtn {
    margin: 1rem 0;
  }
}
</style>