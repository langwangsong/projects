package cn.itcast.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
}
