package com.cs.pojo;

public class Model {
	private int mid;
	private String content;
	private String adminNo;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	@Override
	public String toString() {
		return "Model [mid=" + mid + ", content=" + content + ", adminNo="
				+ adminNo + "]";
	}
	

}
