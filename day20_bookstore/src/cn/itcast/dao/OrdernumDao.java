/**
 * 
 */
package cn.itcast.dao;

import cn.itcast.domain.Ordernum;

/**
 * @author Mr_lang
 *
 */
public interface OrdernumDao {
	Ordernum findOrdernum(String prefix);

	void updateOrdernum(Ordernum ordernum);

	void insertOrdernum(Ordernum ordernum);
}
