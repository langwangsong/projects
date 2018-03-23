package cn.itcast.spring.demo1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 转账的DAO的实现类
 * @author Mr_lang
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	/*private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
*/
	@Override
	/**
	 * from:转出账号
	 * money:转出金额
	 */
	public void outMoney(String from, Double money) {
		String sql="update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql,money,from);
	}

	@Override
	/**
	 * to：转入的账号
	 * money:转入的金额
	 */
	public void inMoney(String to, Double money) {
		String sql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql,money,to);
	}

}
