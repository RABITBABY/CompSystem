package com.cs.pojo;

public class Conditions {
    private Integer conditionid;

    private String conditionname;

    private Integer type;

    public Integer getConditionid() {
        return conditionid;
    }

    public void setConditionid(Integer conditionid) {
        this.conditionid = conditionid;
    }

    public String getConditionname() {
        return conditionname;
    }

    public void setConditionname(String conditionname) {
        this.conditionname = conditionname == null ? null : conditionname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}