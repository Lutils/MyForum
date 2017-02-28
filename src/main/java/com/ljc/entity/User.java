package com.ljc.entity;

import java.io.Serializable;

/**
 * @author LJC 
 * 用户实体
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String username;
	private String password;
	private String headimg; // 用户头像

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
}
