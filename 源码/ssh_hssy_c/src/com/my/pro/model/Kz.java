package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 客照
 * @author 
 *
 */
@Entity
@Table(name="kz")
public class Kz {
	
	private Integer id;
	
    private String name;//简介
	
	private String urls;//主图
	
	private String content;//内容
	
	private Integer dzNum;//点赞数
	
	private Integer isDelete;//是否删除 0 否 1 是

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDzNum() {
		return dzNum;
	}

	public void setDzNum(Integer dzNum) {
		this.dzNum = dzNum;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	
}
