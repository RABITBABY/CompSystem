package com.cs.pojo;

public class Awards {
    private Integer awardsid;

    private Integer comid;

    private String prizename;

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

    public String getPrizename() {
        return prizename;
    }

    public void setPrizename(String prizename) {
        this.prizename = prizename == null ? null : prizename.trim();
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