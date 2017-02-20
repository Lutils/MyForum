package com.ljc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljc.entity.Comment;

public interface CommentDao {

	public int addComment(@Param("content")String content, 
			@Param("aid")Integer aid, 
			@Param("uid")Integer uid, 
			@Param("cuser")String username,
			@Param("date")Timestamp timestamp);

	public List<Comment> findComment(@Param("aid")Integer aid, @Param("uid")Integer uid);

	public int getCommentCount(@Param("aid")Integer aid);

}
