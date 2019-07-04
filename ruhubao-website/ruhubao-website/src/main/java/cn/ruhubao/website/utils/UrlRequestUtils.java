package cn.ruhubao.website.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class UrlRequestUtils {

	//获取路径的方法
	//url=/rtsbiz/page/goto.do
	//	url_buffer=http://localhost:8080/rtsbiz/page/goto.do
	//	queryString=view=/page/jsp/maintainence/meeting/index
	
	public static String getUrl(HttpServletRequest request) {
//		url_buffer=http://localhost:8080/rtsbiz/page/goto.do
		return request.getRequestURL().toString();
	}
	
	public static  String getContextUrl(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		return url.delete(url.length()-request.getRequestURI().length(), url.length()).append(File.separator).toString();
		
	}
	
}
