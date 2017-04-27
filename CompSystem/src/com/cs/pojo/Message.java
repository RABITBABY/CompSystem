package com.cs.pojo;

import java.util.Date;

public class Message {
	
	private Integer id;
	private Integer no;//工号
	private Integer role;//角色
	private Integer from;//该消息来自谁
	private String message;//消息内容
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
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
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
				+ ", from=" + from + ", message=" + message + ", sendDate="
				+ sendDate + ", isRead=" + isRead + "]";
	}
	
	

}
