<template>
  <div>
    <el-dialog v-bind="$attrs" v-on="$listeners" @open="onOpen" @close="onClose" title="Dialog Titile">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-row gutter="15">
          <el-col :span="23">
            <el-form-item label="功能项文件" prop="fpFileUrl" required>
              <el-upload ref="fpFileUrl" :file-list="fpFileUrlfileList" :action="fpFileUrlAction" multiple
                :before-upload="fpFileUrlBeforeUpload" accept=".xls,.xlsx" name="fpFile">
                <el-button size="small" type="primary" icon="el-icon-upload">点击选择文件</el-button>
                <div slot="tip" class="el-upload__tip">只能上传不超过 10MB 的.xls,.xlsx文件</div>
              </el-upload>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handelConfirm">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  inheritAttrs: false,
  components: {},
  props: [],
  data() {
    return {
      formData: {
        fpFileUrl: "",
      },
      rules: {},
      fpFileUrlAction: '/budget/upload',
      fpFileUrlfileList: [],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handelConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
    },
    fpFileUrlBeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 10
      if (!isRightSize) {
        this.$message.error('文件大小超过 10MB')
      }
      let isAccept = new RegExp('.xls,.xlsx').test(file.type)
      if (!isAccept) {
        this.$message.error('应该选择.xls,.xlsx类型的文件')
      }
      return isRightSize && isAccept
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
