package cn.itcast.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
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
}
