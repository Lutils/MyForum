package com.ljc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljc.entity.Article;

public interface ArticleDao {

	public List<Article> getArticleList();

	public Article getArticleByID(@Param("aid")Integer aid);

	public int addArticle(@Param("title") String title,
			@Param("content") String content,
			@Param("date") Timestamp timestamp,
			@Param("uid") Integer uid,
			@Param("lable") String lable);

	public List<Article> getArticleByUID(@Param("uid")Integer uid);

	public int deleteArticleByID(@Param("aid")Integer aid);

	public List<Article> getArticlePageList(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);

	public List<Article> searchArticleByKey(@Param("key")String key);
	
	public List<Article> getArticleListByStatus(List<Integer> statusList);
}
