package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Material {
    private Integer materialId;

    private Student student;
    
    private Condition condition;

    private String materialName;

    private String materialPic;

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialPic() {
		return materialPic;
	}

	public void setMaterialPic(String materialPic) {
		this.materialPic = materialPic;
	}

    
    
    
}
