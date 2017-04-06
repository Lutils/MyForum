package com.ljc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LJC 帖子列表实体
 */

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer aid;
	private String title;
	private String content;
	private Date date;
	private Integer uid;
	private String lable; // 帖子标签
	private Integer status; // 置顶:1、加精:2、加精且置顶:3
	private User author;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
