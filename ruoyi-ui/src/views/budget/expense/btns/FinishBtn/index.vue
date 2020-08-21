<template>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleFinish" v-hasPermi="['budget:expense:finish']"
    >完成审核</el-button>
</template>
<script>
export default {
    props: ['single', 'projectId'],
    methods: {
        handleFinish(row) {
            const ids = this.projectId;
            this.msgSuccess(ids);
        },
    }
}
</script>