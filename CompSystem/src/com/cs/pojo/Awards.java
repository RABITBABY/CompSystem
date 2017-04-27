package com.cs.pojo;

import java.util.Date;

public class Awards {
    private Integer awardsid;

    private Integer comid;

    private String prizename;

    private Integer groupsno;
    
    private String awardsimg;
    
    private Date awardtime;

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

	public Date getAwardtime() {
		return awardtime;
	}

	public void setAwardtime(Date awardtime) {
		this.awardtime = awardtime;
	}

	public String getAwardsimg() {
		return awardsimg;
	}

	public void setAwardsimg(String awardsimg) {
		this.awardsimg = awardsimg;
	}

	@Override
	public String toString() {
		return "Awards [awardsid=" + awardsid + ", comid=" + comid
				+ ", prizename=" + prizename + ", groupsno=" + groupsno
				+ ", awardsimg=" + awardsimg + ", awardtime=" + awardtime
				+ ", ispublish=" + ispublish + "]";
	}
    
    
}