<template>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleAllot" v-hasPermi="['budget:expense:allot']"
    >分配审核</el-button>
</template>
<script>
export default {
    props: ['single', 'projectId'],
    methods: {
        handleAllot(row) {
            const ids = this.projectId;
            this.msgSuccess(ids);
        },
    }
}
</script>