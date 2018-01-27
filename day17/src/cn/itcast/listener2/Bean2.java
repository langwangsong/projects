package cn.itcast.listener2;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 钝化：序列化
 * 活化：反序列化
 * @author Mr_lang
 *
 */
public class Bean2 implements HttpSessionActivationListener,Serializable {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 活化
	 */
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化了。。。");
	}
	/**
	 * 钝化
	 */
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("钝化了、、");
	}
	
}
