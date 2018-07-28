<template>
<div class="searchRecord">
	<div class="search">
		<mu-slide-left-transition mode="in-out">
		  <mu-container v-show="showOut">
		    <mu-form :model="form" ref="form">
		      <mu-form-item label="身份证号" help-text="" :rules="idRules" prop="idCard">
		        <mu-text-field v-model="form.idCard" prop="idCard"></mu-text-field>
		      </mu-form-item>
		      <mu-form-item label="起始时间" help-text="" :rules="startRules" prop="startTime">
		        <mu-date-input v-model="form.startTime" :max-date="form.endTime" label-float full-width prop="startTime"></mu-date-input>
		      </mu-form-item>
		      <mu-form-item label="结束时间" help-text="" :rules="endRules" prop="endTime">
		        <mu-date-input v-model="form.endTime" :min-date="form.startTime" label-float full-width prop="endTime"></mu-date-input>
		      </mu-form-item>
		      <mu-form-item label="口令" help-text="" :rules="passwordRules" prop="password">
		        <mu-text-field v-model="form.password" type="password" prop="password"></mu-text-field>
		      </mu-form-item>
		      <mu-form-item>
		        <mu-button color="primary" @click="submit">查询</mu-button>
		      </mu-form-item>
		    </mu-form>
		  </mu-container>
		</mu-slide-left-transition>
	</div>
	<div class="showRecord">
		<mu-slide-right-transition  mode="out-in">
      <mu-container v-show="showIn">
        <mu-paper>
          <mu-data-table border :columns="columns" :sort.sync="sort" @sort-change="handleSortChange" :data.sync="list">
            <template slot-scope="scope">
              <td class="is-center">{{scope.row.date}}</td>
              <td class="is-left">{{scope.row.hospital}}</td>
              <td class="is-left">{{scope.row.doctor}}</td>
              <td class="is-left">
              	<span v-for="(url, index) in scope.row.numRecord">
		              <a class="showItem" @click="showItem(url)">记录{{index+1}}</a>
		            </span>
              </td>
            </template>
          </mu-data-table>
        </mu-paper>
        <mu-button class="recordBtn" @click="goRecord">返回</mu-button>
      </mu-container>
    </mu-slide-right-transition>
	</div>
	<div>
		<mu-dialog title="记录详情" width="1000" :open.sync="openDetail">
	    <mu-list>
        <mu-list-item class="dialog-item">
          <mu-list-item-action>
            <mu-icon value="category"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-content class="recorditem">
            <span>种类：</span>
            <span>{{record.item}}</span>
          </mu-list-item-content>
        </mu-list-item>
        <mu-list-item class="dialog-item">
          <mu-list-item-action>
            <mu-icon value="event"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-content class="recorditem">
          	<span>科室：</span>
            <span>{{record.category}}</span>
          </mu-list-item-content>
        </mu-list-item>
        <mu-list-item class="dialog-item">
          <mu-list-item-action>
            <mu-icon value="ballot"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-content class="recorditem">
          	<span>病例：</span>
            <span>{{record.proposal}}</span>
          </mu-list-item-content>
        </mu-list-item>
        <mu-list-item class="dialog-item">
          <mu-list-item-action>
            <mu-icon value="where_to_vote"></mu-icon>
          </mu-list-item-action>
          <mu-list-item-content class="recorditem">
          	<span>处方：</span>
            <span>{{record.diagnosis}}</span>
          </mu-list-item-content>
        </mu-list-item>
      </mu-list>
	    <mu-button slot="actions" flat color="primary" @click="closeDetail">Close</mu-button>
	  </mu-dialog>
	</div>
</div>
</template>

<script>
import { checkId, checkToken } from '../assets/common.js'
export default {
	name: 'searchRecord',
	data() {
		return {
			list: [],
			record: {},
      showOut: true,
      showIn: false,
      openDetail: false,
			form: {
				idCard: '',
				startTime: undefined,
				endTime: undefined,
				password: ''
			},
			idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      startRules: [{
        validate: (val) => val !== undefined, message: '请选择起始时间'
      }],
      endRules: [{
        validate: (val) => val !== undefined, message: '请选择结束时间'
      }],
      passwordRules: [{
        validate: (val) => checkToken(val), message: '口令必须是6位数'
      }],
      sort: {
        date: '',
        order: 'desc'
      },
      columns: [
        { title: '诊断时间', name: 'date', width: 180, sortable: true},
        { title: '医院', name: 'hospital', width: 180},
        { title: '医生', name: 'doctor', width: 180},
        { title: '诊断详情', name: 'numRecord'}
      ]
    }
	},
	methods: {
	 	submit() {
	 		this.$refs.form.validate().then(result => {
	 			if (result) {
	 				let form = Object.assign({}, this.form)
	 				const info = this.getData('hospitalInfo')
	 				form['hospital'] = info['hospital'] + ',' + info['doctor']
	 				console.log('req', form)
	 				this.$http.post('api/searchRecord', form).then(res => {
	 					let infos = res.body.infos
	 					for (let info of infos) {
			        let hs = info['hospital'].split(',')
			        info['hospital'] = hs[0]
			        info['doctor'] = hs[1]
			      }
	 					this.list = infos
	 					this.showOut = false
            setTimeout(() => {
              this.showIn = true
            }, 500)
	 				})
	 			}
	 		})
	 	},
	 	handleSortChange ({name, order}) {
      this.list = this.list.sort((a, b) => order === 'asc' ? a[name] - b[name] : b[name] - a[name]);
    },
    goRecord() {
      this.showIn = false
      setTimeout(() => {
        this.showOut = true
      }, 500)
    },
    closeDetail() {
    	this.openDetail = false
    },
    showItem(url) {
    	// this.$http.get(url).then(res => {
    	this.$http.get('/api/singleRecord').then(res => {
    		this.record = res.body
    		this.openDetail = true
    	})
    }	
	}
}
</script>

<style lang = "scss">
.recordBtn {
	margin-top: 20px;
}
.showItem {
	cursor: pointer;
	padding: 0 2px;
}
.recorditem {
	span:first-child {
		position: absolute;
		display: flex;
    align-items: center;
	}
	span:last-child {
		padding-left: 5rem;
		display: block;
	} 
}
.dialog-item {
	margin: .5rem 0;
}
</style>