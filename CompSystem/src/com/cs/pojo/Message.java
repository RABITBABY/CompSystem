package com.cs.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message {
	
	private Integer id;
	private Integer no;//工号
	private Integer role;//角色
	private Integer fromNo;//该消息来自谁
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
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public Integer getFromNo() {
		return fromNo;
	}
	public void setFromNo(Integer fromNo) {
		this.fromNo = fromNo;
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
		return "Message [id=" + id + ", no=" + no + ", role=" + role
				+ ", from=" + fromNo + ", message=" + message + ", sendDate="
				+ sendDate + ", isRead=" + isRead + "]";
	}
	
	

}
