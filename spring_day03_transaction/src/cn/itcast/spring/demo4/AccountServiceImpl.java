package cn.itcast.spring.demo4;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	/**
	 * propagation:传播行为
	 * isolation:隔离级别
	 * readOnly:只读
	 * timeout:超时信息
	 * rollbackFor:发生哪些异常回滚
	 * noRollbackFor:发生哪些异常不回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void transfer(String from,String to, Double money) {
		accountDao.outMoney(from, money);
		int d = 10/0;
		accountDao.inMoney(to, money);
		
	}
	

}
