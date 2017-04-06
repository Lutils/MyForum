package com.ljc.entity;

import java.io.Serializable;

/**
 * @author LJC 楼中楼评论
 */
public class Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer fid;
	private Integer cid;
	private Integer uid;
	private String content;
	private User floorReplyer;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getFloorReplyer() {
		return floorReplyer;
	}

	public void setFloorReplyer(User floorReplyer) {
		this.floorReplyer = floorReplyer;
	}

}
