<template>
<div>
    <el-button :disabled="single"
        type="primary" icon="el-icon-edit" size="mini"
        @click="handleCheck" v-hasPermi="['budget:expense:check']"
    >流程查看</el-button>
    <el-dialog title="项目流程查看" :visible.sync="display">
    <el-timeline>
        <el-timeline-item
        v-for="(activity, index) in activities"
        :key="index"
        :timestamp="activity.timestamp">
        {{activity.content}}
        </el-timeline-item>
    </el-timeline>
  </el-dialog>
</div>
</template>
<script>
export default {
    props: ['single', 'projectId'],
    data() {
      return {
        display: false,
        activities: []
      };
    },
    methods: {
        handleCheck(row) {
            const ids = this.projectId;
            this.display = true;
        },
    },
    created() {
      this.activities = [{
          content: '活动按期开始',
          timestamp: '2018-04-15'
        }, {
          content: '通过审核',
          timestamp: '2018-04-13'
        }, {
          content: '创建成功',
          timestamp: '2018-04-11'
        }];
    }
}
</script>
