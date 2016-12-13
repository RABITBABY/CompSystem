package com.cs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private Integer comId;

    private String comName;

    private Integer levelId;

    private String hunit;

    private String sorganizer;

    private Date applyBeginDate;

    private Date applyEndDate;

    private Date comDate;

    private BigDecimal cost;

    private Integer status;

    private Integer isPublish;

    private String introduction;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
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

    public Date getApplyBeginDate() {
        return applyBeginDate;
    }

    public void setApplyBeginDate(Date applyBeginDate) {
        this.applyBeginDate = applyBeginDate;
    }

    public Date getApplyEndDate() {
        return applyEndDate;
    }

    public void setApplyEndDate(Date applyEndDate) {
        this.applyEndDate = applyEndDate;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
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

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}