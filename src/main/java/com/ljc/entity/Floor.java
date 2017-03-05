package com.ljc.entity;

import java.io.Serializable;

/**
 * @author LJC
 * 楼中楼评论
 */
public class Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer fid;
	private Integer cid;
	private Integer uid;
	private String content;
	private String cuser; // 评论者昵称
	private String uimg; // 评论者头像

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

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

}
