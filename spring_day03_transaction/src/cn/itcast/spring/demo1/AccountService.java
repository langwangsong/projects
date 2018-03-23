package cn.itcast.spring.demo1;
/**
 * 转账的业务层接口
 * @author Mr_lang
 *
 */
public interface AccountService {
	public void transfer(String from,String to,Double money);
}
