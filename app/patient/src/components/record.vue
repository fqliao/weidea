<template>
<div class="record">
  <mu-container>
    <mu-button class="recordBtn" @click="goIndex">返回</mu-button>
    <mu-paper>
      <mu-data-table :columns="columns" :sort.sync="sort" @sort-change="handleSortChange" :data.sync="list">
        <template slot-scope="scope">
          <td class="is-center">{{scope.row.date}}</td>
          <td class="is-left">{{scope.row.hospital}}</td>
          <td class="is-left">{{scope.row.category}}</td>
          <td class="is-left">{{scope.row.item}}</td>
          <td class="is-left">{{scope.row.proposal}}</td>
          <td class="is-left">{{scope.row.prescription}}</td>
        </template>
      </mu-data-table>
    </mu-paper>
  </mu-container>
</div>
</template>

<script>
export default {
	name: 'record',
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
        { title: '科室', name: 'category', width: 120},
        { title: '检测项目', name: 'item', width: 180},
        { title: '诊断结果', name: 'proposal', width: 250},
        { title: '处方', name: 'prescription', width: 250}
      ]
    }
	},
  created() {
    const userInfo = this.getData('userInfo')
    let head = {
      idCard: userInfo.idCard,
      password: userInfo.password
    }
    this.$http.post('api/record', head).then(res => {
      this.list = res.body.medicalRecords
    })
  },
  methods: {
    handleSortChange({name, order}) {
      this.list = this.list.sort((a, b) => order === 'asc' ? a[name] - b[name] : b[name] - a[name]);
    },
    goIndex() {
      this.$router.push('/')
    }
  }
}
</script>

<style lang = "scss">
.record {
  margin: 1rem;
  .recordBtn {
    margin: 1rem 0;
  }
}

</style>