package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Hours {
    private Integer hoursId;

    private Competition competition;

    private String type;

    private Integer hours;

    private String remarks;

    public Integer getHoursId() {
        return hoursId;
    }

    public void setHoursId(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public Competition getCompetition() {
		return competition;
	}
    
    public void setCompetition(Competition competition) {
		this.competition = competition;
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
}
