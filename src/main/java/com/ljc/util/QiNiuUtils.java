package com.ljc.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.ljc.config.Config;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author LJC 
 * 七牛云操作工具类
 */
public class QiNiuUtils {

	public static DefaultPutRet upLoad(MultipartFile file, String bucket) {

		// 构造一个带指定Zone对象的配置类 (华东)
		Configuration cfg = new Configuration(Zone.zone0());

		// 文件上传Manager
		UploadManager uploadManager = new UploadManager(cfg);

		// 得到上传文件的文件名，并赋值给key作为七牛存储的文件名
		String key = System.currentTimeMillis() + "." + 
						file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

		// 把文件转化为字节数组
		byte[] uploadBytes = null;
		try(InputStream is = file.getInputStream();
			ByteArrayOutputStream 	bos = new ByteArrayOutputStream()) {
			
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = is.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			uploadBytes = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 七牛云授权
		Auth auth = Auth.create(Config.QINIU_ACCESS_KEY,Config.QINIU_SECRET_KEY);

		String upToken = auth.uploadToken(bucket);
		// 默认上传接口回复对象  
		DefaultPutRet putRet = null;
		// 进行上传操作
		Response response = null;
		try {
			//上传文件
			response = uploadManager.put(uploadBytes, key, upToken);
			//返回json
			putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		} catch (QiniuException e) {
			e.printStackTrace();
		}
		
		return putRet;
	}

}
