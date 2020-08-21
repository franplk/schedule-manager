package com.ruoyi.budget.enums;

public enum ProjectStatus {

    NEW_CREATED("新建", 0),
    APPLYING("申报中", 1),
    ALLOTTING("待分配", 2),
    PRE_AUDIT("待审核", 3),
    AUDITING("审核中", 4),
    FINISHED("已完成", 5);

    private String name;
    private Integer value;

    private ProjectStatus(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
