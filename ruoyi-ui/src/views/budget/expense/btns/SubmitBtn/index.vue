<template>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleSubmit" v-hasPermi="['budget:expense:submit']"
    >提交审核</el-button>
</template>
<script>
export default {
    props: ['single', 'projectId'],
    methods: {
        handleSubmit(row) {
            const ids = this.projectId;
            this.msgSuccess(ids);
        },
    }
}
</script>