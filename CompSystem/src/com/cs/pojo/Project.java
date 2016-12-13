package com.cs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private Integer comid;

    private String comname;

    private Integer levelid;

    private String hunit;

    private String sorganizer;

    private Date applybegindate;

    private Date applyenddate;

    private Date comdate;

    private BigDecimal cost;

    private Integer status;

    private Integer ispublish;

    private String introduction;

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getHunit() {
        return hunit;
    }

    public void setHunit(String hunit) {
        this.hunit = hunit == null ? null : hunit.trim();
    }

    public String getSorganizer() {
        return sorganizer;
    }

    public void setSorganizer(String sorganizer) {
        this.sorganizer = sorganizer == null ? null : sorganizer.trim();
    }

    public Date getApplybegindate() {
        return applybegindate;
    }

    public void setApplybegindate(Date applybegindate) {
        this.applybegindate = applybegindate;
    }

    public Date getApplyenddate() {
        return applyenddate;
    }

    public void setApplyenddate(Date applyenddate) {
        this.applyenddate = applyenddate;
    }

    public Date getComdate() {
        return comdate;
    }

    public void setComdate(Date comdate) {
        this.comdate = comdate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}