package com.ljc.dao;

import org.apache.ibatis.annotations.Param;

import com.ljc.entity.User;

public interface UserDao {

	public int addUser(@Param("username") String username,
			@Param("password") String password, @Param("headimg") String headimg);

	public User findUser(@Param("username") String username,
			@Param("password") String password);

	public User getUserByID(@Param("uid") Integer uid);

	public int updateHeadImg(@Param("headimg") String headImgName,
			@Param("uid") Integer uid);

	public int updateUserInfo(@Param("uid") Integer uid,
			@Param("password") String password);

}
