package cn.itcast.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request被销毁了");
	}
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request被创建了");
	}

}
