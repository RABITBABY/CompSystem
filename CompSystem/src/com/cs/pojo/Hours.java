package com.cs.pojo;

public class Hours {
	private Integer hoursid;

	private Integer comid;

	private String type;

	private Integer hours;

	private String remarks;

	public Integer getHoursid() {
		return hoursid;
	}

	public void setHoursid(Integer hoursid) {
		this.hoursid = hoursid;
	}

	public Integer getComid() {
		return comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	@Override
	public String toString() {
		return "Hours [hoursid=" + hoursid + ", comid=" + comid + ", type="
				+ type + ", hours=" + hours + ", remarks=" + remarks + "]";
	}
	
	

}