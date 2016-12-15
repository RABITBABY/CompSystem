package com.cs.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Awards {
    private Integer awardsId;

    private Competition competition;

    private String name;

    private Date date;

    private String hunit;

    private Prize prize;

    private Level level;

    private Groups groups;

    private Integer isPublish;

	public Integer getAwardsId() {
		return awardsId;
	}

	public void setAwardsId(Integer awardsId) {
		this.awardsId = awardsId;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.hunit = hunit;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

}
