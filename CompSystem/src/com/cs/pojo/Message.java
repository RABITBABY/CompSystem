package com.cs.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message {
	
	private Integer id;
	private String sendtoNo;//推送消息给谁。工号
	private String sendtoName;
	private Integer role;//角色
	private String fromNo;//该消息来自谁
	private String fromName;
	private String message;//消息内容
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sendDate;//发送日期
	private Integer isRead;//是否已读
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSendtoNo() {
		return sendtoNo;
	}
	public void setSendtoNo(String sendtoNo) {
		this.sendtoNo = sendtoNo;
	}
	public String getSendtoName() {
		return sendtoName;
	}
	public void setSendtoName(String sendtoName) {
		this.sendtoName = sendtoName;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getFromNo() {
		return fromNo;
	}
	public void setFromNo(String fromNo) {
		this.fromNo = fromNo;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Integer getIsRead() {
		return isRead;
	}
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sendtoNo=" + sendtoNo + ", sendtoName="
				+ sendtoName + ", role=" + role + ", fromNo=" + fromNo
				+ ", fromName=" + fromName + ", message=" + message
				+ ", sendDate=" + sendDate + ", isRead=" + isRead + "]";
	}
	
	

}
