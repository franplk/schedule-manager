<template>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleApply" v-hasPermi="['budget:expense:apply']"
    >费用申报</el-button>
</template>

<script>
import { applyProject } from "@/api/budget/project"

export default {
    props: ['single', 'projectId'],
    methods: {
        handleApply(row) {
            applyProject(this.projectId).then(response => {
              if(200 == response.code) {
                this.$router.replace("/calendar");
              } else {
                this.msgError(response.msg);
              }
            });
        },
    }
}
</script>
