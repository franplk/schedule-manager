<template>
  <div id="app" class="app-container">
    <div class="full-calendar">
      <FullCalendar ref="calendar" :options="calendarOptions" />
    </div>
    <!-- 添加或修改日程对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" size="medium" label-width="100px">
        <el-col>
          <el-form-item label="全天事件" prop="allday">
            <el-radio-group v-model="form.allday">
              <el-radio label="1">是</el-radio>
              <el-radio label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="日程名称" prop="title">
            <el-input v-model="form.title" placeholder="请输入名称" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="事件等级" prop="level">
            <el-select v-model="form.level" :style="{width: '100%'}" placeholder="请选择事件等级">
              <el-option v-for="dict in levelOptions"
                :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开始时间" prop="startTime">
            <el-date-picker type="datetime" v-model="form.startTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              :style="{width: '100%'}" placeholder="请选择开始时间">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="结束时间" prop="stopTime">
            <el-date-picker type="datetime" v-model="form.stopTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              :style="{width: '100%'}" placeholder="请选择结束时间" clearable>
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="计划人员" prop="planner">
            <el-select v-model="form.planner" :style="{width: '100%'}" placeholder="请选择计划人员">
              <el-option v-for="dict in plannerOptions"
                :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="提交人员" prop="supporter">
            <el-select v-model="form.supporter" :style="{width: '100%'}" placeholder="请选择提交人员">
              <el-option v-for="dict in plannerOptions"
                :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注信息" prop="remark">
            <el-input v-model="form.remark" type="textarea" placeholder="请输入备注信息"
              :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button type="danger" @click="handleDelete" v-if="deleting">删 除</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import FullCalendar from '@fullcalendar/vue';
import listMonth from "@fullcalendar/list";
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from "@fullcalendar/timegrid";
import allLocales from "@fullcalendar/core/locales-all";
import interactionPlugin from '@fullcalendar/interaction';
import { parseTime } from '@/utils/ruoyi.js'
import { listSchedule, delSchedule, addSchedule, updateSchedule } from "@/api/calendar/schedule";

export default {
  name: "Schedule",
  components: {
    FullCalendar
  },
  data() {
    return {
      title: "", open: false,
      form: {}, deleting: false,
      loading: true, scheduleList: [],
      levelOptions: [], plannerOptions: [],
      rules: {
        title: [
          { required: true, message: "日程名称不能为空", trigger: "blur" }
        ],
        startTime: [
          { required: true, message: "开始时间不能为空", trigger: "blur" }
        ]
      }
    }
  },
  created() {
    this.getList();
    this.getDicts("oss_schedule_level").then(response => {
      this.levelOptions = response.data;
    });
    this.getDicts("oss_calendar_planner").then(response => {
      this.plannerOptions = response.data;
    });
  },
  computed: {
    calendarOptions: function() {
      return {
        events: this.scheduleList,
        editable: true, selectable: true, droppable: false,
        locales: allLocales, locale: 'zh-cn',
        selectMirror: true, dayMaxEvents: true,
        firstDay:'1', initialView: 'dayGridMonth',
        headerToolbar: {
            left: 'prev,next,today', center: 'title',
            right:'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
        },
        plugins: [
          dayGridPlugin, timeGridPlugin, interactionPlugin, listMonth
        ],
        dateClick: this.handleAdd, eventClick: this.handleUpdate
      }
    }
  },
  methods: {
    // 查询日程列表
    getList() {
      this.loading = true;
      listSchedule(this.queryParams).then(response => {
        this.loading = false;
        let dataList = response.data;
        this.scheduleList = dataList.map(item => {
          return {
            remark: item.remark,
            allDay: Boolean(item.allday),
            id: item.id, title: item.title,
            backgroundColor: item.level || 'blue',
            start: item.startTime, end: item.stopTime,
            planner: item.planner, supporter: item.supporter
          }
        });
      });
    },
    // 事件等级字典翻译
    levelFormat(row, column) {
      return this.selectDictLabel(this.levelOptions, row.level);
    },
    plannerFormat(row, column) {
      return this.selectDictLabel(this.plannerOptions, row.planner);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.deleting = false;
    },
    /** 新增按钮操作 */
    handleAdd(info) {
      this.form = {
        allday: '1', startTime: parseTime(info.date)
      };
      this.resetForm("form");
      this.open = true;
      this.title = "添加日程";
      this.deleting = false;
    },
    /** 修改按钮操作 */
    handleUpdate(info) {
      let schedule = info.event;
      let extendProps = schedule.extendedProps;
      this.form = {
        id: schedule.id, title: schedule.title, allday: schedule.allDay ? '1' : '0',
        startTime: parseTime(schedule.start), stopTime: parseTime(schedule.end),
        planner: extendProps.planner, supporter: extendProps.supporter,
        level: schedule.backgroundColor, remark: extendProps.remark
      };
      this.resetForm("form");
      this.open = true;
      this.title = "修改日程";
      this.deleting = true;
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        if (this.form.id != null) {
          updateSchedule(this.form).then(response => {
            if (response.code === 200) {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }
          });
        } else {
          console.log(JSON.stringify(this.form));
          addSchedule(this.form).then(response => {
            if (response.code === 200) {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }
          });
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(event) {
      let curForm = this.form;
      let id = curForm.id, title = curForm.title;
      this.$confirm('确认删除日程【"' + title + '"】吗?', "警告", {
        type: "warning",
        confirmButtonText: "确定", cancelButtonText: "取消"
      }).then(function() {
        return delSchedule(id);
      }).then(() => {
        this.cancel();
        this.msgSuccess("删除成功");
        this.getList();
      }).catch(function() {});
    }
  }
}
</script>

<style scoped>
.full-calendar {
  flex: 1;
  width: 80%;
  margin: 30px auto;
}
</style>
