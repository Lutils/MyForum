package com.ljc.service;

import java.sql.Timestamp;
import java.util.List;

import com.ljc.entity.Comment;


public interface CommentService {

	/**
	 * 发表评论
	 * @param content
	 * @param aid
	 * @param uid
	 * @param timestamp
	 * @return
	 */
	public int addComment(String content, Integer aid, Integer uid ,Timestamp timestamp);
	
	/**
	 * 通过id获得评论数据
	 * @param aid
	 * @param uid
	 * @return
	 */
	public List<Comment> findComment(Integer aid, Integer uid);
	
	/**
	 * 通过aid获得该帖子回复数量
	 * @param aid
	 * @return
	 */
	public int getCommentCount(Integer aid);

}
