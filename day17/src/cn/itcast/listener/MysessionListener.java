package cn.itcast.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听session域对象的创建和销毁
 * @author Mr_lang
 *
 */
public class MysessionListener implements HttpSessionListener  {
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session被创建了");
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
			System.out.println("session被销毁了");
	}
}
