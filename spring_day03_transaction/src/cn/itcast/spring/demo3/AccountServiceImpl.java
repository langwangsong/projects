package cn.itcast.spring.demo3;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账的业务层实现类
 * @author Mr_lang
 *
 */
public class AccountServiceImpl implements AccountService {
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	private AccountDao accountDao;
	@Override
	/**
	 * from:转出账号
	 * to:转入账号
	 * money:转账的金额
	 */
	public void transfer(String from,String to, Double money) {
		accountDao.outMoney(from, money);
		int d = 10/0;
		accountDao.inMoney(to, money);
		
	}
	

}
