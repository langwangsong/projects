package cn.itcast.spring.demo1;
/**
 * 转账的DAO接口
 * @author Mr_lang
 *
 */
public interface AccountDao {
	public void outMoney(String from,Double money);
	public void inMoney(String to,Double money);
}	
