package com.my.pro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_message")
public class UserMessage {
	private Integer id;
	private User sendUser;//发送人
	private User resivrUser;//接收人
	private Date createTime;//
	private Message message;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="message_id")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	private int isRead;//是否已读 1是  2 否
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sendser_id")
	public User getSendUser() {
		return sendUser;
	}
	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resiveruser_id")
	public User getResivrUser() {
		return resivrUser;
	}
	public void setResivrUser(User resivrUser) {
		this.resivrUser = resivrUser;
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

}
