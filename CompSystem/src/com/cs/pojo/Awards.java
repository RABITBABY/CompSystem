package com.cs.pojo;

import java.util.Date;

public class Awards {
    private Integer awardsid;

    private Integer comid;

    private String name;

    private Date date;

    private String hunit;

    private Integer prizeid;

    private Integer levelid;

    private Integer groupsno;

    private Integer ispublish;

    public Integer getAwardsid() {
        return awardsid;
    }

    public void setAwardsid(Integer awardsid) {
        this.awardsid = awardsid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHunit() {
        return hunit;
    }

    public void setHunit(String hunit) {
        this.hunit = hunit == null ? null : hunit.trim();
    }

    public Integer getPrizeid() {
        return prizeid;
    }

    public void setPrizeid(Integer prizeid) {
        this.prizeid = prizeid;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public Integer getGroupsno() {
        return groupsno;
    }

    public void setGroupsno(Integer groupsno) {
        this.groupsno = groupsno;
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }
}