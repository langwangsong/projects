package cn.itcast.listener2;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 绑定和解除绑定
 * @author Mr_lang
 *
 */
public class Bean1 implements HttpSessionBindingListener {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 绑定：把JavaBean存入到session中
	 */
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("绑定");
	}
	/**
	 * 解除绑定：从session中移除JavaBean
	 */
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("解除绑定");
	}
}
