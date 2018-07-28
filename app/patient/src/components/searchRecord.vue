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
          <td class="is-left">
            <span v-for="(i, index) in scope.row.numRecord">
              <a class="showItem" @click="showItem(i)">记录{{index+1}}</a>
            </span>
          </td>
        </template>
      </mu-data-table>
    </mu-paper>
  </mu-container>
  <mu-dialog title="记录详情" width="1000" :open.sync="openDetail">
    <mu-list>
      <mu-list-item class="dialog-item">
        <mu-list-item-action>
          <span>种类：</span>
        </mu-list-item-action>
        <mu-list-item-content class="recorditem">
          <span>{{record.item}}</span>
        </mu-list-item-content>
      </mu-list-item>
      <mu-list-item class="dialog-item">
        <mu-list-item-action>
          <span>科室：</span>
        </mu-list-item-action>
        <mu-list-item-content class="recorditem">
          <span>{{record.category}}</span>
        </mu-list-item-content>
      </mu-list-item>
      <mu-list-item class="dialog-item">
        <mu-list-item-action>
          <span>病历：</span>
        </mu-list-item-action>
        <mu-list-item-content class="recorditem">
          <span>{{record.proposal}}</span>
        </mu-list-item-content>
      </mu-list-item>
      <mu-list-item class="dialog-item">
        <mu-list-item-action>
          <span>处方：</span>
        </mu-list-item-action>
        <mu-list-item-content class="recorditem">
          <span>{{record.diagnosis}}</span>
        </mu-list-item-content>
      </mu-list-item>
    </mu-list>
    <mu-button slot="actions" flat color="primary" @click="closeDetail">Close</mu-button>
  </mu-dialog>
</div>
</template>

<script>
export default {
	name: 'searchRecord',
	data() {
		return {
			list: [],
      record: {},
      openDetail: false,
      sort: {
        date: '',
        order: 'desc'
      },
      columns: [
        { title: '诊断时间', name: 'date', width: 120, sortable: true},
        { title: '医院', name: 'hospital', width: 120},
        { title: '医生', name: 'doctor', width: 120},
        { title: '诊断详情', name: 'numRecord', width: 180}
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
      console.log(infos)
			this.list = infos
		})
	},
	methods: {
	 	handleSortChange ({name, order}) {
      this.list = this.list.sort((a, b) => order === 'asc' ? a[name] - b[name] : b[name] - a[name]);
    },
    goIndex() {
      this.$router.push('/')
    },
    closeDetail() {
      this.openDetail = false
    },
    showItem(index) {
      const form = this.form
      let head = {
        index: index,
        idCard: form['idCard'],
        password: form['password']
      }
      this.$http.get('/api/onerecord').then(res => {
        this.record = res.body
        this.openDetail = true
      })
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
.recordBtn {
  margin-top: 20px;
}
.recorditem {
  display: flex;
  span:first-child {
    flex: 0 0 auto;
    display: flex;
    align-items: center;
  }
  span:last-child {
    flex: 1 1 auto;
  } 
}
.showItem {
  cursor: pointer;
  padding: 0 2px;
}
</style>