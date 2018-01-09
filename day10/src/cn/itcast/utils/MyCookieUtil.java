package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie相关的工具类
 * @author Mr_lang
 *
 */

public class MyCookieUtil {
	public static Cookie getCookieByName(Cookie [] cookies,String cookieName){
		//有可能数组是空的
		if(cookies == null ){
			return null;
		}else{
			for(Cookie cookie:cookies){
				if(cookie.getName().equals(cookieName)){
					return cookie;
				}
			}
		}
		return null;
	}
}
