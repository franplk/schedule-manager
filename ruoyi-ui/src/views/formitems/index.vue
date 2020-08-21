<template>
  <el-input v-model="value" placeholder="请输入单行文本" :style="{width: '100%'}">
    <template slot="append">
      <a @click="open">搜索</a>
    </template>
  </el-input>
</template>

<script>
  export default {
    props:[],
    data() {
      return {
        value: 111
      }
    },
    methods: {
      open(evt) {
        this.msgSuccess('hhh');
        this.value = '222'
      }
    }
  }
</script>

<style>
</style>
