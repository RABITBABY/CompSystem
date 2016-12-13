package com.cs.pojo;

public class Material {
    private Integer materialid;

    private Integer studentno;

    private String materialname;

    private String materialpic;

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

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname == null ? null : materialname.trim();
    }

    public String getMaterialpic() {
        return materialpic;
    }

    public void setMaterialpic(String materialpic) {
        this.materialpic = materialpic == null ? null : materialpic.trim();
    }
}