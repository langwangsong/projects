package cn.itcast.utils;
/**
 * 注册的异常
 * @author Mr_lang
 *
 */
public class MyRegistException extends  Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyRegistException() {
		super();
	}
	public MyRegistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public MyRegistException(String message, Throwable cause) {
		super(message, cause);
	}
	public MyRegistException(String message) {
		super(message);	
	}
	public MyRegistException(Throwable cause) {
		super(cause);	
	}
	
}
