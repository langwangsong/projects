package cn.itcast.utils;
/**
 * 
 * @author Mr_lang
 *
 */
public class AccountException extends Exception{

	public AccountException() {
		super();
	}

	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
