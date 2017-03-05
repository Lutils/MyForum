package com.ljc.service;

import java.sql.Timestamp;
import java.util.List;

import com.ljc.entity.Comment;
import com.ljc.entity.Floor;


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

	/**
	 * 根据cid获取楼中楼评论数据
	 * @param aid
	 * @param cid
	 * @return
	 */
	public List<Floor> findFloorComment(Integer aid, Integer cid);

	/**
	 * 添加楼中楼评论
	 * @param aid
	 * @param cid
	 * @param uid
	 * @param content
	 * @return
	 */
	public int addFloorComment(Integer aid, Integer cid, Integer uid,
			String content);

}
