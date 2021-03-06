package com.cs.pojo;

import java.util.Date;

public class Production {
  

	private Integer proid;

    private String proname;

    private String award;

    private String membersname;

    private String pic;

    private String introduction;
    
    private Date createDate;

    
    public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }

    public String getMembersname() {
        return membersname;
    }

    public void setMembersname(String membersname) {
        this.membersname = membersname == null ? null : membersname.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

	@Override
	public String toString() {
		return "Production [proid=" + proid + ", proname=" + proname
				+ ", award=" + award + ", membersname=" + membersname
				+ ", pic=" + pic + ", introduction=" + introduction
				+ ", createDate=" + createDate + "]";
	}
    
   
}