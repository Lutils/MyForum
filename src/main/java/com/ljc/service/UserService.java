package com.ljc.service;

import com.ljc.entity.User;

public interface UserService {

	/**
	 * 注册用户
	 * @param username
	 * @param password
	 * @param headimg 
	 * @return
	 */
	public int addUser(String username, String password, String headimg);

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUser(String username, String password);

	/**
	 * 根据id查询用户
	 * @param uid
	 * @return
	 */
	public User getUserByID(Integer uid);

	/**
	 * 更新头像
	 * @param headImgName
	 * @param uid 
	 * @return
	 */
	public int updateHeadImg(String headImgName, Integer uid);

	/**
	 * 根据uid更新对应用户信息
	 * @param uid
	 * @param password
	 * @return
	 */
	public int updateUserInfo(Integer uid, String password);


}
