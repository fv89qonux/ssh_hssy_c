package com.my.pro.dto;

import java.util.Date;


public class MessageDto {
	private int id;
	private String content;
	private int sendUserId;//发送人
	private String sendUserName;
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	private int resivrUserId;//接收人
	private Date createTime;//发送时间
	private int isRead;//1已读 2未读
	private String createTimeStr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}
	public int getResivrUserId() {
		return resivrUserId;
	}
	public void setResivrUserId(int resivrUserId) {
		this.resivrUserId = resivrUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}
