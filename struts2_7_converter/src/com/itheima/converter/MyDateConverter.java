package com.itheima.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConverter extends StrutsTypeConverter {
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	//把String转为其他类型：写操作
	/**
	 * Map context :后面要学习的ContextMap。是Struts2的数据中心
	 * String[] values :用户输入的数据
	 * Class toClass ：转换成的目标类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//得到用户输入值
		if(values!=null && values.length>0){
			String stringdate = values[0];// 12/12/2012
			if(toClass==Date.class){
				//目标类型是java.util.Date类型
				try {
					return df.parseObject(stringdate);
				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	//把其他类型转为String：读操作
	/**
	 * Map context ：后面要学习的ContextMap。是Struts2的数据中心
	 * Object o : 其他类型
	 */
	@Override
	public String convertToString(Map context, Object o) {
		if(o!=null && o.getClass()==Date.class){
			//数据是java.util.Date类型的
			return df.format((Date)o);
		}
		return null;
	}

}
