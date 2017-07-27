package com.ljc.config;

/**
 * @author LJC
 * 存储静态数据
 */
public class Config {

	/**
	 * 默认头像地址
	 */
	public static final String DEFAULT_HEADIMG_ADDRESS = "/resources/imgs/head.png";
	
	/**
	 * 默认文件上传地址
	 */
	public static final String DEFAULT_UPLOAD_ADDRESS = "/resources/upload";
	
	/**
	 * 默认分页大小
	 */
	public static final int DEFAULT_PAGESIZE = 10;
	
	/**
	 * 置顶帖status
	 */
	public static final int STATUS_TOP = 1;
	
	/**
	 * 精品帖status
	 */
	public static final int STATUS_HOT = 2;
	
	/**
	 * 置顶且加精品status
	 */
	public static final int STATUS_TOP_HOT = 3;
	
	/**
	 * 七牛云	AccessKey
	 */
	public static final String QINIU_ACCESS_KEY = "tqzVOKV-LjEy2gQG5hbBe2iv8XzZAXAHB11mOwZ8";
	/**
	 * 七牛云 SecretKey
	 */
	public static final String QINIU_SECRET_KEY = "YPhQja32sQ_aifoS8tXzPkSY-FMa_49yu8wedNuO";
	/**
	 * 七牛云头像存储Bucket
	 */
	public static final String QINIU_BUCKET_HEADIMG = "headimg";
	
	/**
	 * 七牛云图片存储测试地址
	 */
	public static final String QINIU_IMG_URL = "http://odudqy2qz.bkt.clouddn.com/";
	
}
