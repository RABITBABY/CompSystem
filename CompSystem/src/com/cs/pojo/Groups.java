package com.cs.pojo;

public class Groups {
    private Integer groupsNo;

    private Integer comId;

    private String groupsName;

    private Integer teacherNo;

    private Integer status;

    public Integer getGroupsNo() {
        return groupsNo;
    }

    public void setGroupsNo(Integer groupsNo) {
        this.groupsNo = groupsNo;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName == null ? null : groupsName.trim();
    }

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacheNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}