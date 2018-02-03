package cn.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.OrdernumDao;
import cn.itcast.domain.Ordernum;

public class OrdernumDaoImpl extends JdbcDaoSupport  implements OrdernumDao {

	@Override
	public Ordernum findOrdernum(String prefix) {
		String sql = "select * from ordernum where prefix = ?";
		return query(sql,new BeanHandler<Ordernum>(Ordernum.class),prefix);
	}

	@Override
	public void updateOrdernum(Ordernum ordernum) {
		String sql = "update ordernum set serialNum=? where prefix=?";
		update(sql,ordernum.getSerialNum(),ordernum.getPrefix());
	}

	@Override
	public void insertOrdernum(Ordernum ordernum) {
		String sql = "insert into ordernum (prefix,serialNum) values(?,?)";
		update(sql,ordernum.getPrefix(),ordernum.getSerialNum());
	}

}
