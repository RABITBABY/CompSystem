package com.cs.pojo;

public class Groups {
	
	private Integer id;
	
    private Integer groupsno;

    private Integer comid;

    private String groupsname;

    private Integer teacherno;

    private Integer studentno;

    private Integer status;

    private Integer captainstatus;
    
    private Integer iscaptain;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupsno() {
        return groupsno;
    }

    public void setGroupsno(Integer groupsno) {
        this.groupsno = groupsno;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getGroupsname() {
        return groupsname;
    }

    public void setGroupsname(String groupsname) {
        this.groupsname = groupsname == null ? null : groupsname.trim();
    }

    public Integer getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(Integer teacherno) {
        this.teacherno = teacherno;
    }

    public Integer getStudentno() {
        return studentno;
    }

    public void setStudentno(Integer studentno) {
        this.studentno = studentno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Integer getCaptainstatus() {
		return captainstatus;
	}

	public void setCaptainstatus(Integer captainstatus) {
		this.captainstatus = captainstatus;
	}

	public Integer getIscaptain() {
		return iscaptain;
	}

	public void setIscaptain(Integer iscaptain) {
		this.iscaptain = iscaptain;
	}
    
	
    
}