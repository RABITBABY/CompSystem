package com.cs.pojo;

public class Level {
    private Integer levelid;

    private String levelname;

    private String prizename;

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname == null ? null : levelname.trim();
    }

    public String getPrizename() {
        return prizename;
    }

    public void setPrizename(String prizename) {
        this.prizename = prizename == null ? null : prizename.trim();
    }

	@Override
	public String toString() {
		return "Level [levelid=" + levelid + ", levelname=" + levelname
				+ ", prizename=" + prizename + "]";
	}
    
    
}