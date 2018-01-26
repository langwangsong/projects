package cn.itcast.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrdersItem;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.utils.MyJdbcUtils;
import cn.itcast.utils.MyUUIDUtils;
import cn.itcast.utils.ProductException;

/**
 * 商品模块的业务层
 * @author Mr_lang
 *
 */
public class ProductService {
	/**
	 * 添加商品
	 * @param p
	 * @throws SQLException 
	 * @throws ProductException 
	 */
	public void addProduct(Product p) throws SQLException, ProductException{
		//添加主键
		String id = MyUUIDUtils.getUUID();
		p.setId(id);
		//调用持久层，完成添加的功能
		ProductDao dao = new ProductDao();
		dao.save(p);
	}

	public List<Product> findAll() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findAll();
	}
	/**
	 * 通过主键来查询商品的信息
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Product findById(String id) throws SQLException{
		ProductDao dao = new ProductDao();
		return dao.findById(id);
	}
	/**
	 * 修改商品的信息
	 * @param p
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException{
		ProductDao dao = new ProductDao();
		dao.update(p);
	}
	/**
	 * 删除选中的
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteSelect(String[] ids) throws SQLException {
		ProductDao dao = new ProductDao();
		dao.deleteSelect(ids);
	}
	/**
	 * 多条件查询
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findByWhere(String id, String category, String name, String minprice, String maxprice) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findByWhere(id,category,name,minprice,maxprice);
	}

	public PageBean<Product> findByPage(int pageCode, int pageSize) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.fingByPage(pageCode,pageSize);
	}
	/**
	 * 保存订单
	 * 	开启事务
	 * 	先保存订单的相关的数据
	 * 	还需要保存订单项的数据
	 * 	修改商品的库存
	 * 	提交事务
	 * 	回滚事务
	 * @param order
	 */
	public void saveOrder(Order order) {
		//先定义结构
		Connection conn = null;
		try{
			conn =  MyJdbcUtils.getConn();
			conn.setAutoCommit(false);
			//调用持久层
			ProductDao dao = new ProductDao();
			//先保存订单的相关数据
			dao.saveOrder(conn,order);
			//还需要保存订单项的数据
			//一个订单有多个订单项
			List<OrdersItem> ordersItems = order.getOrdersItems();
			//h欧渠道每一个订单项
			for (OrdersItem ordersItem : ordersItems) {
				//保存订单项的方法
				dao.saveOrdersItem(conn,ordersItem);
			}
			//修改商品的库存
			for (OrdersItem ordersItem : ordersItems) {
				//获取到订单中的商品
				Product p = ordersItem.getProduct();
				//获取到该商品的主键
				String pId = p.getId();
				//获取到该商品被卖了多少个
				int buyCount = p.getBuyCount();
				//编写方法
				dao.updateProductPnum(conn,buyCount,pId);
			}
			//如果没有问题，提交事务
			conn.commit();
		}catch (Exception e) {
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			//归还连接
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
