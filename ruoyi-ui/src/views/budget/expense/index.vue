<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="项目名称" prop="name">
        <el-input
          v-model="queryParams.name" placeholder="请输入项目名称"
          clearable size="small" @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option v-for="dict in statusOptions"
            :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <ApplyBtn :single="single" :projectId="ids" />
      </el-col>
      <el-col :span="1.5">
        <SubmitBtn :single="single" :projectId="ids" />
      </el-col>
      <el-col :span="1.5">
        <AllotBtn :single="single" :projectId="ids" />
      </el-col>
      <el-col :span="1.5">
        <AuditBtn :single="single" :projectId="ids" />
      </el-col>
      <el-col :span="1.5">
        <FinishBtn :single="single" :projectId="ids" />
      </el-col>
      <el-col :span="1.5">
        <FlowBtn :single="single" :projectId="ids" />
      </el-col>
      <div class="top-right-btn">
        <el-col :span="1.5">
          <el-button type="warning" icon="el-icon-refresh" size="mini" @click="handleQuery">刷新</el-button>
        </el-col>
      </div>
    </el-row>

    <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange" style="width: 100%">
      <el-table-column type="selection" width="50" align="center" />
      <el-table-column label="项目编码" align="center" prop="code" />
      <el-table-column label="项目名称" align="center" prop="name" />
      <el-table-column label="状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="申报金额" align="center" prop="applySum" />
      <el-table-column label="审核金额" align="center" prop="auditSum" />
      <el-table-column label="核增/核减" align="center">
        <template slot-scope="scope">
          {{scope.row.auditSum - scope.row.applySum}}
        </template>
      </el-table-column>
      <el-table-column label="项目描述" align="center" prop="remark" />
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"  @pagination="getList"/>
  </div>
</template>

<script>
import { ApplyBtn, SubmitBtn, AllotBtn, AuditBtn, FinishBtn, FlowBtn, WordBtn, ExcelBtn } from "./btns"
import { listExpense } from "@/api/budget/expense";

export default {
  name: "Expense",
  components: {
    ApplyBtn, SubmitBtn, AllotBtn, AuditBtn, FinishBtn, FlowBtn, WordBtn, ExcelBtn
  },
  data() {
    return {
      loading: true, ids: [], single: true, multiple: true,
      total: 0, projectList: [], statusOptions: [],
      queryParams: {
        pageNum: 1, pageSize: 10, name: null, status: null,
      },
      form: {},
      rules: {
        name: [
          { required: true, message: "项目名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("oss_project_status").then(response => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询项目列表列表 */
    getList() {
      this.loading = true;
      listExpense(this.queryParams).then(response => {
        this.projectList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    }
  }
};
</script>
