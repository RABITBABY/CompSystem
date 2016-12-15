package com.cs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Project {
    private Competition competition;

    private String comName;

    private Level level;

    private String hunit;

    private String sorganizer;

    private Date applyBeginDate;

    private Date applyEndDate;

    private Date comDate;

    private BigDecimal cost;

    private Integer status;

    private Integer isPublish;

    private String introduction;
    
    private Integer isGroup;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }
    
    

    public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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

	public Integer getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(Integer isGroup) {
		this.isGroup = isGroup;
	}
    
    
}