package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Budget {
    private Integer budgetId;

    private Integer comId;

    private String subject;

    private Integer sum;

    private String reasons;

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetid(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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
}