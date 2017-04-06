package com.ljc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LJC 评论内容实体
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cid;
	private String content;
	private Integer aid;
	private Integer uid;
	private Date date;
	private User replyer;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getReplyer() {
		return replyer;
	}

	public void setReplyer(User replyer) {
		this.replyer = replyer;
	}

}
