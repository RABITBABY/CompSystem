package com.cs.pojo;

public class Material {
    private Integer materialid;

    private Integer studentno;

    private Integer conditionid;

    private String materialpic;

    private Integer status;

    public Integer getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }

    public Integer getStudentno() {
        return studentno;
    }

    public void setStudentno(Integer studentno) {
        this.studentno = studentno;
    }

    public Integer getConditionid() {
        return conditionid;
    }

    public void setConditionid(Integer conditionid) {
        this.conditionid = conditionid;
    }

    public String getMaterialpic() {
        return materialpic;
    }

    public void setMaterialpic(String materialpic) {
        this.materialpic = materialpic == null ? null : materialpic.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}