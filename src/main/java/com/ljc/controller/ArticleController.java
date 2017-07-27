package com.ljc.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ljc.config.Config;
import com.ljc.entity.Article;
import com.ljc.entity.Comment;
import com.ljc.entity.Floor;
import com.ljc.entity.User;
import com.ljc.service.ArticleService;
import com.ljc.service.CommentService;
import com.ljc.service.UserService;
import com.ljc.util.LogUtils;
import com.ljc.util.StringUtils;

/**
 * @author LJC 
 * 帖子列表Controller
 */
@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	
	/**
	 * 获取帖子分页数据
	 * @return
	 */
	@RequestMapping("/list/{currentPage}")
	public ModelAndView getArticlePageList(HttpSession session,
			@PathVariable("currentPage") int currentPage){
		ModelAndView mav = new ModelAndView();
		int pageSize = Config.DEFAULT_PAGESIZE;// 每页记录数
		mav.addObject("articlePageBean", articleService.getArticlePageList(currentPage,pageSize));

		List<Integer> statusList = new ArrayList<>();
		statusList.add(Config.STATUS_TOP);	//置顶帖
		statusList.add(Config.STATUS_TOP_HOT);	//置顶且加精帖
		mav.addObject("topArticle", articleService.getArticleListByStatus(statusList));
		
		//刷新session
		if(session.getAttribute("user") != null){
			User user = (User) session.getAttribute("user");
			session.setAttribute("user", userService.getUserByID(user.getUid()));
		}
		mav.setViewName("article/articleList");
		return mav;
	}
	
	/**
	 * 根据id获取帖子数据
	 * @param aid
	 * @return
	 */
	@RequestMapping("/details/{aid}")
	public ModelAndView getArticleByID(@PathVariable("aid") Integer aid){
		ModelAndView mav = new ModelAndView();
		//帖子数据
		Article article = articleService.getArticleByID(aid);
		//评论数据
		List<Comment> commentList = commentService.findComment(aid, null);
		//楼中楼评论数据
		List<Floor> floorCommentList = commentService.findFloorComment(aid, null);
		//数据存放至Model
		mav.addObject(article);
		mav.addObject(commentList);
		mav.addObject("Floor", floorCommentList);
		//设置视图
		mav.setViewName("article/articleContent");
		return mav;
	}

	/**
	 * 添加楼中楼评论
	 * @param aid
	 * @param cid
	 * @param uid
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/floor/add", method = RequestMethod.POST)
	public Map<String,String> findFloorComment(HttpSession session,
			@RequestParam("aid") Integer aid,
			@RequestParam("cid") Integer cid,
			@RequestParam("uid") Integer uid,
			@RequestParam("content") String content){
		Map<String,String> map = new HashMap<String,String>();
		//身份检测
		User user = (User) session.getAttribute("user");	//当前登录用户
		if(user.getUid() != uid){
			map.put("data", "回复失败！");
			return map;
		}
		//楼中楼评论数据
		int result = commentService.addFloorComment(aid,cid,uid,content);
		if(result>0){
			LogUtils.info("楼中楼评论成功!内容=>"+content);
//			map.put("data", "回复成功！");
		}else{
			LogUtils.info("楼中楼评论失败!");
//			map.put("data", "回复失败！");
		}
		return map;
	}

	/**
	 * 根据id删除帖子数据
	 * @param aid
	 * @return
	 */
	@RequestMapping("/delete/{aid}")
	@ResponseBody
	public Map<String, String> deleteArticleByID(HttpSession session,@PathVariable("aid") Integer aid){
		Map<String, String> map = new HashMap<>();
		//身份检测
		User user = (User) session.getAttribute("user");	//当前登录用户
//		Integer uid = articleService.getArticleByID(aid).getUid();	//帖子作者
		Integer uid = articleService.getArticleByID(aid).getAuthor().getUid();	//帖子作者
		if(user.getUid() != uid){
			map.put("data", "只能删除自己的帖子！");
			return map;
		}
		int result = articleService.deleteArticleByID(aid);
		if(result>0){
			LogUtils.info("成功删除id为{}的帖子！",aid);
			map.put("data", "删除成功！");
		}else{
			LogUtils.info("删除失败id为{}的帖子！",aid);
			map.put("data", "删除失败！");
		}
		return map;
	}
	
	/**
	 * 发表新帖
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addArticle(HttpSession session,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "uid") Integer uid,
			@RequestParam(value = "lable") String lable){
		Map<String, String> map = new HashMap<>();
		//身份检测
		User user = (User) session.getAttribute("user");
		if(user == null){
			map.put("data", "请登录后在发帖！");
			return map;
		}
		if(StringUtils.isEmpty(title) || StringUtils.isBlank(title)){
			map.put("data", "标题不能为空！");
			return map;
		}
		int result = articleService.addArticle(title,content,new Timestamp(new Date().getTime()),uid,lable);
		if(result>0){
			LogUtils.info("发帖成功,标题:{},内容长度:{}",title,content.length());
			map.put("data", "发帖成功！");
		}else{
			LogUtils.info("发帖失败！");
		}
		return map;
	}
	
	/**
	 * 关键字查询帖子标题
	 * @param key
	 * @return
	 */
	@RequestMapping("/search")
	public ModelAndView SearchArticle(@RequestParam("key")String key){
		ModelAndView mav = new ModelAndView();
		List<Article> list = articleService.searchArticleByKey(key);
		LogUtils.info("查询关键字:{},共查询到{}条记录",key,list.size());
		mav.addObject("key",key);
		mav.addObject("resultList",list);
		mav.setViewName("search");
		return mav;
	}
	
}
