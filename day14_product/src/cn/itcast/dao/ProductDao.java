package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Product;
import cn.itcast.utils.MyJdbcUtils;
import cn.itcast.utils.MyUUIDUtils;
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
}
