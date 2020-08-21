<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目ID" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入项目ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="条目ID" prop="tpmId">
        <el-input
          v-model="queryParams.tpmId"
          placeholder="请输入条目ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="条目上级ID" prop="tpmPid">
        <el-input
          v-model="queryParams.tpmPid"
          placeholder="请输入条目上级ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="条目名称" prop="itemName">
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入条目名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申报金额" prop="applysum">
        <el-input
          v-model="queryParams.applysum"
          placeholder="请输入申报金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申报数量" prop="applyNum">
        <el-input
          v-model="queryParams.applyNum"
          placeholder="请输入申报数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申报单价" prop="applyPrice">
        <el-input
          v-model="queryParams.applyPrice"
          placeholder="请输入申报单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申报因子" prop="applyFactor">
        <el-input
          v-model="queryParams.applyFactor"
          placeholder="请输入申报因子"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核金额" prop="auditSum">
        <el-input
          v-model="queryParams.auditSum"
          placeholder="请输入审核金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核数量" prop="auditNum">
        <el-input
          v-model="queryParams.auditNum"
          placeholder="请输入审核数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核金额" prop="auditPrice">
        <el-input
          v-model="queryParams.auditPrice"
          placeholder="请输入审核金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核因子" prop="auditFactor">
        <el-input
          v-model="queryParams.auditFactor"
          placeholder="请输入审核因子"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注信息" prop="memo">
        <el-input
          v-model="queryParams.memo"
          placeholder="请输入备注信息"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
	    <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['budget:expense:add']"
        >新增</el-button>
      </el-col>
      <div class="top-right-btn">
        <el-tooltip class="item" effect="dark" content="刷新" placement="top">
          <el-button size="mini" circle icon="el-icon-refresh" @click="handleQuery" />
        </el-tooltip>
        <el-tooltip class="item" effect="dark" :content="showSearch ? '隐藏搜索' : '显示搜索'" placement="top">
          <el-button size="mini" circle icon="el-icon-search" @click="showSearch=!showSearch" />
        </el-tooltip>
      </div>
    </el-row>

    <el-table
      v-loading="loading"
      :data="expenseList"
      row-key="tpmid"
      default-expand-all
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
    >
      <el-table-column label="项目ID" align="center" prop="projectId" />
      <el-table-column label="条目ID" align="center" prop="tpmId" />
      <el-table-column label="条目上级ID" align="center" prop="tpmPid" />
      <el-table-column label="条目名称" align="center" prop="itemName" />
      <el-table-column label="申报金额" align="center" prop="applysum" />
      <el-table-column label="申报数量" align="center" prop="applyNum" />
      <el-table-column label="申报单价" align="center" prop="applyPrice" />
      <el-table-column label="申报因子" align="center" prop="applyFactor" />
      <el-table-column label="审核金额" align="center" prop="auditSum" />
      <el-table-column label="审核数量" align="center" prop="auditNum" />
      <el-table-column label="审核金额" align="center" prop="auditPrice" />
      <el-table-column label="审核因子" align="center" prop="auditFactor" />
      <el-table-column label="备注信息" align="center" prop="memo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['budget:expense:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['budget:expense:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改项目预算对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目ID" />
        </el-form-item>
        <el-form-item label="条目ID" prop="tpmId">
          <el-input v-model="form.tpmId" placeholder="请输入条目ID" />
        </el-form-item>
        <el-form-item label="条目上级ID" prop="tpmPid">
          <el-input v-model="form.tpmPid" placeholder="请输入条目上级ID" />
        </el-form-item>
        <el-form-item label="条目名称" prop="itemName">
          <el-input v-model="form.itemName" placeholder="请输入条目名称" />
        </el-form-item>
        <el-form-item label="申报金额" prop="applysum">
          <el-input v-model="form.applysum" placeholder="请输入申报金额" />
        </el-form-item>
        <el-form-item label="申报数量" prop="applyNum">
          <el-input v-model="form.applyNum" placeholder="请输入申报数量" />
        </el-form-item>
        <el-form-item label="申报单价" prop="applyPrice">
          <el-input v-model="form.applyPrice" placeholder="请输入申报单价" />
        </el-form-item>
        <el-form-item label="申报因子" prop="applyFactor">
          <el-input v-model="form.applyFactor" placeholder="请输入申报因子" />
        </el-form-item>
        <el-form-item label="审核金额" prop="auditSum">
          <el-input v-model="form.auditSum" placeholder="请输入审核金额" />
        </el-form-item>
        <el-form-item label="审核数量" prop="auditNum">
          <el-input v-model="form.auditNum" placeholder="请输入审核数量" />
        </el-form-item>
        <el-form-item label="审核金额" prop="auditPrice">
          <el-input v-model="form.auditPrice" placeholder="请输入审核金额" />
        </el-form-item>
        <el-form-item label="审核因子" prop="auditFactor">
          <el-input v-model="form.auditFactor" placeholder="请输入审核因子" />
        </el-form-item>
        <el-form-item label="备注信息" prop="memo">
          <el-input v-model="form.memo" placeholder="请输入备注信息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listExpense, getExpense, delExpense, addExpense, updateExpense, exportExpense } from "@/api/budget/expense";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Expense",
  components: { Treeselect },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 项目预算表格数据
      expenseList: [],
      // 项目预算树选项
      expenseOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        projectId: null,
        tpmId: null,
        tpmPid: null,
        itemName: null,
        applysum: null,
        applyNum: null,
        applyPrice: null,
        applyFactor: null,
        auditSum: null,
        auditNum: null,
        auditPrice: null,
        auditFactor: null,
        memo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectId: [
          { required: true, message: "项目ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项目预算列表 */
    getList() {
      this.loading = true;
      listExpense(this.queryParams).then(response => {
        this.expenseList = this.handleTree(response.data, "tpmid", "tpmpid");
        this.loading = false;
      });
    },
    /** 转换项目预算数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.tpmid,
        label: node.itemname,
        children: node.children
      };
    },
	/** 查询部门下拉树结构 */
    getTreeselect() {
      listExpense().then(response => {
        this.expenseOptions = [];
        const data = { tpmid: 0, itemname: '顶级节点', children: [] };
        data.children = this.handleTree(response.data, "tpmid", "tpmpid");
        this.expenseOptions.push(data);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        projectId: null,
        tpmId: null,
        tpmPid: null,
        itemName: null,
        applysum: null,
        applyNum: null,
        applyPrice: null,
        applyFactor: null,
        auditSum: null,
        auditNum: null,
        auditPrice: null,
        auditFactor: null,
        memo: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
	  this.getTreeselect();
      this.open = true;
      this.title = "添加项目预算";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
	  this.getTreeselect();
      if (row != null) {
        this.form.tpmpid = row.tpmid;
      }
      getExpense(row.id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目预算";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExpense(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addExpense(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.$confirm('是否确认删除项目预算编号为"' + row.id + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delExpense(row.id);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    }
  }
};
</script>