package cn.itcast.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
//Javabean中的属性名称和表单中的字段名称一致
// name -->getName|setName
public class MyBeanUtil {
	/**
	 * 把请求中的参数封装到JavaBean中
	 * @param request：请求对象
	 * @param clazz：JavaBean类型
	 * @return 目标对象
	 */
	public static <T> T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();//目标对象
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
