<template>
<div class="record">
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
          <mu-form-item label="科室" help-text="" :rules="categoryRules" prop="category">
            <mu-text-field v-model="form.category" prop="category"></mu-text-field>
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
    <mu-slide-right-transition mode="out-in">
      <mu-container v-show="showIn">
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
        <mu-button class="recordBtn" @click="goRecord">返回</mu-button>
      </mu-container>
    </mu-slide-right-transition>
  </div>
</div>
</template>

<script>
import { checkId, checkToken } from '../assets/common.js' 
export default {
	name: 'record',
	data() {
		return {
      list: [],
      showOut: true,
      showIn: false,
      form: {
        idCard: '',
        startTime: undefined,
        endTime: undefined,
        category: '',
        password: ''
      },
      idRules: [{
        validate: (val) => checkId(val), message: '身份证号码校验错误'
      }],
      categoryRules: [{
        validate: (val) => val.length > 0, message: '科室信息为必填项'
      }],
      passwordRules: [{
        validate: (val) => checkToken(val), message: '口令必须是6位数'
      }],
      startRules: [{
        validate: (val) => val !== undefined, message: '请选择起始时间'
      }],
      endRules: [{
        validate: (val) => val !== undefined, message: '请选择结束时间'
      }],
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
  },
  methods: {
    submit() {
      this.$refs.form.validate().then(result => {
        if (result) {
          let form = Object.assign({}, this.form)
          this.$http.post('api/record', form).then(res => {
            this.list = res.body.medicalRecords
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
    goRecord () {
      this.showIn = false
      setTimeout(() => {
        this.showOut = true
      }, 500)
    }
  }
}
</script>

<style lang = "scss">
.recordBtn {
  margin-top: 20px;
}
</style>