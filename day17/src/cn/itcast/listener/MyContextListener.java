package cn.itcast.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 实现特定的接口，实现该接口中的所有方法
 * @author Mr_lang
 *
 */
public class MyContextListener implements ServletContextListener {
	/**
	 * ServletContext对象一旦被创建，该方法就执行了
	 * 该方法的对象就是事件对象
	 * 事件对象的作用：获取到事件源对象
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext被销毁了...");
	}
	/**
	 * ServletContext被销毁，该方法就执行了
	 */
	public void contextInitialized(ServletContextEvent sce) {
		//通过事件对象获取到事件源对象
		ServletContext context = sce.getServletContext();
		String myPath = context.getInitParameter("myPath");
		//向ServletContext域对象中存入值
		context.setAttribute("myPath", myPath);
		System.out.println("ServletContext被创建了...");
	}
}
