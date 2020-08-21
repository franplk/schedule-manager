<template>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleAudit" v-hasPermi="['budget:expense:audit']"
    >费用审核</el-button>
</template>
<script>
export default {
    props: ['single', 'projectId'],
    methods: {
        handleAudit(row) {
            const ids = row.id;
            this.msgSuccess(ids);
        },
    }
}
</script>