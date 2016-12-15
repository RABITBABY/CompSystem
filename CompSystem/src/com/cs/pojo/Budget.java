package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Budget {
    private Integer budgetId;

    private Competition competition;

    private String subject;

    private Integer sum;

    private String reasons;

	public Integer getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
}
