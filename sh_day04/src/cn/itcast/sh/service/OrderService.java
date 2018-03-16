package cn.itcast.sh.service;

import java.util.List;

import cn.itcast.sh.dao.OrderDao;
import cn.itcast.sh.domain.Order;

public class OrderService {

	public List<Order> findByCid(Integer cid) {
		return OrderDao.findByCid(cid);
	}
	
}
