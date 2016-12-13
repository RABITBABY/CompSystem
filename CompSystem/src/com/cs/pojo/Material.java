package com.cs.pojo;

public class Material {
    private Integer materialId;

    private Integer studentNo;

    private String materialName;

    private String materialPic;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialPic() {
        return materialPic;
    }

    public void setMaterialPic(String materialPic) {
        this.materialPic = materialPic == null ? null : materialPic.trim();
    }
}