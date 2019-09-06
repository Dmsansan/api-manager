<template>
  <div>
    <Card>
      <tables ref="tables" editable searchable search-place="top" v-model="tableData" :columns="columns" @on-delete="handleDelete"/>
      <Button style="margin: 10px 0;" type="primary" @click="exportExcel">导出为Csv文件</Button>
    </Card>
  </div>
</template>

<script>
  import Tables from '_c/tables'
  import { getTableData, formatDate } from '@/api/user'
  export default {
    name: 'user-list',
    components: {
      Tables
    },
    data () {
      return {
        columns: [
          { title: '用户ID', key: 'id', sortable: true},
          { title: '用户名', key: 'userName', editable: true },
          { title: '密码', key: 'passWord', editable: true },
          { title: '创建时间', key: 'addTime', render: (h,params)=>{
              return h('div',
                formatDate(new Date(params.row.addTime),'yyyy-MM-dd hh:mm:ss')
              )
            }
          },
          { title: '最近更新时间', key: 'lastUpdateTime', render: (h,params)=>{
              return h('div',
                formatDate(new Date(params.row.addTime),'yyyy-MM-dd hh:mm:ss')
              )
            }
          },
          {
            title: '操作',
            key: 'handle',
            options: ['delete'],
            button: [
              (h, params, vm) => {
                return h('Poptip', {
                  props: {
                    confirm: true,
                    title: '你确定要删除吗?'
                  },
                  on: {
                    'on-ok': () => {
                      vm.$emit('on-delete', params)
                      vm.$emit('input', params.tableData.filter((item, index) => index !== params.row.initRowIndex))
                    }
                  }
                })
              }
            ]
          }
        ],
        tableData: []
      }
    },
    methods: {
      handleDelete (params) {
        console.log(params)
      },
      exportExcel () {
        this.$refs.tables.exportCsv({
          filename: `table-${(new Date()).valueOf()}.csv`
        })
      }
    },
    mounted () {
      getTableData().then(res => {
        this.tableData = res.data
      })
    }
  }
</script>

<style>

</style>
