package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class GroupsDetail {
    private Integer id;

    private Integer groupsNo;

    private Integer studentNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupsNo() {
        return groupsNo;
    }

    public void setGroupsNo(Integer groupsNo) {
        this.groupsNo = groupsNo;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }
}