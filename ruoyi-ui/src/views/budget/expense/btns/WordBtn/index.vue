<template>
    <el-button
        type="primary" icon="el-icon-download" size="mini"
        @click="handleExport" v-hasPermi="['budget:project:export']"
    >导出为WORD</el-button>
</template>
<script>
export default {
    props: ['projectId'],
    methods: {
        handleExport(row) {
            const ids = this.projectId;
            this.msgSuccess(ids);
        }
    }
}
</script>