package com.cs.pojo;

public class Budget {
    private Integer budgetid;

    private Integer comid;

    private String subject;

    private Integer sum;

    private String reasons;

    public Integer getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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
        this.reasons = reasons == null ? null : reasons.trim();
    }

	@Override
	public String toString() {
		return "Budget [budgetid=" + budgetid + ", comid=" + comid
				+ ", subject=" + subject + ", sum=" + sum + ", reasons="
				+ reasons + "]";
	}
    
    
}