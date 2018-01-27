package cn.itcast.listener1;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {
	/**
	 * 添加
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("向session中添加了属性");
	}
	/**
	 * 移除
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("向session中移除了属性");
	}
	/**
	 * 替换
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("向session中替换了属性");
	}

}
