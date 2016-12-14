package com.cs.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Awards {
    private Integer awardsId;

    private Integer comId;

    private String name;

    private Date date;

    private String hunit;

    private Integer prizeId;

    private Integer levelId;

    private Integer groupsNo;

    private Integer isPublish;

    public Integer getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(Integer awardsid) {
        this.awardsId = awardsid;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comid) {
        this.comId = comid;
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

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeid) {
        this.prizeId = prizeid;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelid) {
        this.levelId = levelid;
    }

    public Integer getGroupsNo() {
        return groupsNo;
    }

    public void setGroupsNo(Integer groupsno) {
        this.groupsNo = groupsno;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer ispublish) {
        this.isPublish = ispublish;
    }
}