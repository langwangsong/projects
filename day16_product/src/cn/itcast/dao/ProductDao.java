package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Order;
import cn.itcast.domain.OrdersItem;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.utils.MyJdbcUtils;
import cn.itcast.utils.ProductException;

/**
 * 商品的持久层
 * @author Mr_lang
 *
 */
public class ProductDao {
	/**
	 * 保存商品的数据
	 * @param p
	 * @throws SQLException 
	 * @throws ProductException 
	 */
	public void save(Product p) throws SQLException, ProductException{
		//使用DBUtils来保存数据
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		String sql = "insert into products values(?,?,?,?,?,?)";
		//存储数据的数组
		Object [] params = {p.getId(),p.getName(),p.getPrice(),p.getPnum(),p.getCategory(),p.getDescription()};
		//调用update方法
		int count = runner.update(sql,params);
		//不成功
		if(count == 0 ){
			throw new ProductException("添加数据失败");
		}
	}

	public List<Product> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		//查询所有的商品信息
		return runner.query("select * from products",new BeanListHandler<Product>(Product.class));
	}

	public Product findById(String id) throws SQLException {
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		return runner.query("select * from products where id = ?", new BeanHandler<Product>(Product.class),id);
	}

	public void update(Product p) throws SQLException {
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		String sql = "update products set name=?,price=?,pnum=?,category=?,description=? where id = ?";
		Object [] params = {p.getName(),p.getPrice(),p.getPnum(),p.getCategory(),p.getDescription(),p.getId()};
		runner.update(sql, params);
	}
	/**
	 * 删除选中
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteSelect(String[] ids) throws SQLException {
		// 使用批处理  把一维的转换成二维的
  		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
  		//编写删除的SQL语句
  		String sql = "delete from products where id =?";
  		
  		Object [][] params = new Object [ids.length][1];
  		//把一位数组中的值复制到二维数组中
  		for (int i = 0; i < ids.length; i++) {
			params[i][0] = ids[i];
		}
  		//删除的方法
  		runner.batch(sql,params);
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
		//学习：怎样来拼接SQL语句，技巧！！！
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		//定义集合，存储参数的值
		List<Object> list = new ArrayList<Object>();
		//编写SQL语句
		StringBuffer sb= new StringBuffer("select * from products where 1=1 ");
		//判断，如果id不为空，拼接SQL语句
		if(id != null && !id.trim().isEmpty()){
			sb.append(" and id like ?");
			// id like ? 
			list.add("%"+id+"%");
		}
		if(category != null && !category.trim().isEmpty()){
			sb.append(" and category = ?");
			list.add(category);
		}
		if(name != null && !name.trim().isEmpty()){
			sb.append(" and name like ?");
			list.add("%"+name+"%");
		}
		if(minprice != null && !minprice.trim().isEmpty()){
			sb.append(" and price > ?");
			list.add(minprice);
		}
		if(maxprice != null && !maxprice.trim().isEmpty()){
			sb.append(" and price < ?");
			list.add(maxprice);
		}
		return runner.query(sb.toString(),new BeanListHandler<Product>(Product.class),list.toArray());
	}
	/**
	 * 分页查询
	 * @param pageCode
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Product> fingByPage(int pageCode, int pageSize) throws SQLException {
		//目的：把PageBean对象中所有属性的封装全部都封装好，返回
		PageBean<Product> page = new PageBean<Product>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		//还剩下总记录数和每页显示的数据
		QueryRunner runner = new QueryRunner(MyJdbcUtils.getDataSource());
		//page.setTotalCount(totalCount);
		String countSql = "select count(*) from products";
		long count =(long) runner.query(countSql, new ScalarHandler());
		page.setTotalCount((int)count);
		//page.setBeanList(beanList); limit关键字的使用
		String selectSql = "select * from products limit ?,?";
		List<Product> beanList = runner.query(selectSql, new BeanListHandler<Product>(Product.class),(pageCode - 1)*pageSize,pageSize);
		page.setBeanList(beanList);
		return page;
	}
	/**
	 * 保存订单
	 * @param conn
	 * @param order
	 * @throws SQLException 
	 */
	public void saveOrder(Connection conn, Order order) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into orders values (?,?,?,?,?,?)";
		Object [] params =  {order.getId(),order.getReceiverAddress(),order.getReceiverName(),order.getReceiverPhone(),order.getTotalprice(),order.getUser().getId()};
		//执行
		runner.update(conn,sql,params);
	}
	/**
	 * 保存订单项
	 * @param conn
	 * @param ordersItem
	 * @throws SQLException 
	 */
	public void saveOrdersItem(Connection conn, OrdersItem ordersItem) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into ordersitem values (?,?,?,?)";
		Object [] params =  {ordersItem.getItemId(),ordersItem.getOrder().getId(),ordersItem.getProduct().getId(),ordersItem.getSubtotal()};
		//执行
		runner.update(conn,sql,params);
	}
	/**
	 * 修改商品库存
	 * @param conn
	 * @param buyCount
	 * @param pId
	 * @throws SQLException 
	 */
	public void updateProductPnum(Connection conn, int buyCount, String pId) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "update products set pnum = pnum - ? where id = ?";
		Object [] params = {buyCount,pId};
		runner.update(conn, sql, params);
	}
}
