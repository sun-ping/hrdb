<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="funcName">
      <el-input v-model="dataForm.funcName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="type">
      <el-input v-model="dataForm.type" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="column2">
      <el-input v-model="dataForm.column2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="column3">
      <el-input v-model="dataForm.column3" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          funcId: 0,
          parentId: '',
          funcName: '',
          type: '',
          column2: '',
          column3: ''
        },
        dataRule: {
          parentId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          funcName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          column2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          column3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.funcId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.funcId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/funcname/info/${this.dataForm.funcId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.parentId = data.funcname.parentId
                this.dataForm.funcName = data.funcname.funcName
                this.dataForm.type = data.funcname.type
                this.dataForm.column2 = data.funcname.column2
                this.dataForm.column3 = data.funcname.column3
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/funcname/${!this.dataForm.funcId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'funcId': this.dataForm.funcId || undefined,
                'parentId': this.dataForm.parentId,
                'funcName': this.dataForm.funcName,
                'type': this.dataForm.type,
                'column2': this.dataForm.column2,
                'column3': this.dataForm.column3
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
