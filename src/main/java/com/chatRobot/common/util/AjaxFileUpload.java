package com.chatRobot.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;



/**
 * 图片上传
 *
 * 
 */
public class AjaxFileUpload {
	
	public static String ajaxUploadImg(MultipartFile file, HttpServletRequest request,String dirName) {
		//存放路径
		String realPath = request.getRealPath("");
		if(!realPath.endsWith(File.separator)){
			realPath += File.separator;
		}
		//文件后缀
		String originalFilename = file.getOriginalFilename();
		String suffix = ".jpg";
		if(originalFilename.lastIndexOf(".") != -1){
			suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		}
		//年月日文件夹
		String yearDir = new SimpleDateFormat("yyyyMMdd").format(new Date());
		//文件名称
		String fileName = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date())+suffix;
		String filePath = "/public/upload"+File.separator+dirName+File.separator+yearDir+File.separator+fileName;
		File destFile = new File(realPath+filePath);
		if(!destFile.getParentFile().exists()){
			destFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
		return filePath;
	}
	
}
