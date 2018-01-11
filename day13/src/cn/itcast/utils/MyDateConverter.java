package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * 自定义类型转换
 * @author Mr_lang
 *
 */
public class MyDateConverter implements Converter {
	/**
	 * 就是完成日期转换
	 * type代表注册时候传入的class类型
	 * value代表用户输入的值
	 * 目的：吧用户输入的值，转换成日期
	 */
	public Object convert(Class type,Object value){
		//System.out.println(type);
		//System.out.println(value);
		//目的：把字符串转换成日期
		String sDate = (String) value;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
