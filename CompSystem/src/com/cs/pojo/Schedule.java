package com.cs.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {
	private Integer id;
	
    private Integer comid;

    private Integer teacherno;

    private String content;

    private String position;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Integer hours;
    
    public Integer getId() {
		return id;
	}
    
    public void setId(Integer id) {
		this.id = id;
	}

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(Integer teacherno) {
        this.teacherno = teacherno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", comid=" + comid + ", teacherno="
				+ teacherno + ", content=" + content + ", position=" + position
				+ ", date=" + date + ", hours=" + hours + "]";
	}
    
    
}