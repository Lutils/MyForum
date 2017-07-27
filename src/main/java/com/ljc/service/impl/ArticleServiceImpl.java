package com.ljc.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.dao.ArticleDao;
import com.ljc.entity.Article;
import com.ljc.entity.PageBean;
import com.ljc.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<Article> getArticleList() {
		return articleDao.getArticleList();
	}

	@Override
	public Article getArticleByID(Integer aid) {
		return articleDao.getArticleByID(aid);
	}

	@Override
	public int addArticle(String title, String content, Timestamp timestamp,
			Integer uid, String lable) {
		return articleDao.addArticle(title, content, timestamp, uid, lable);
	}

	@Override
	public List<Article> getArticleByUID(Integer uid) {
		return articleDao.getArticleByUID(uid);
	}

	@Override
	public int deleteArticleByID(Integer aid) {
		return articleDao.deleteArticleByID(aid);
	}

	@Override
	public PageBean getArticlePageList(int currentPage, int pageSize) {
		int count = articleDao.getArticleList().size();
		int totalPage = (int) Math.ceil(count * 1.0 / pageSize);// 总页数
		List<Article> articleList = articleDao.getArticlePageList(
				(currentPage - 1) * pageSize, pageSize);
		PageBean pageBean = new PageBean(currentPage, pageSize, count,
				totalPage, articleList);
		return pageBean;
	}

	@Override
	public List<Article> searchArticleByKey(String key) {
		return articleDao.searchArticleByKey(key);
	}

	@Override
	public List<Article> getArticleListByStatus(List<Integer> statusList) {
		return articleDao.getArticleListByStatus(statusList);
	}


}
