package cn.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.RuntimeErrorException;

import cn.itcast.domain.User;
import cn.itcast.utils.MyJdbcUtils;
import cn.itcast.utils.MyRegistException;
/**
 * 持久层，用来操作数据
 * @author Mr_lang
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 保存用户
	 * @throws MyRegistException 
	 * 
	 */
	public void save(User user) throws MyRegistException {
		//操作数据库，吧数据保存到数据库中
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = MyJdbcUtils.getConn();
			String sql = "insert into user values(null,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getSex());
			stmt.setString(4, user.getTelephone());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getIntroduce());
			
			int count = stmt.executeUpdate();
			if(count!=1){
				throw new MyRegistException("注册失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyRegistException("注册失败：方法内部执行错误");
		}finally{
			MyJdbcUtils.releaseAll(stmt, conn);
		}
	}

	@Override
	public User loginUser(User user) {
		//操作数据库，吧数据保存到数据库中
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MyJdbcUtils.getConn();
			String sql = "select * from user where username=? and password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()){
				User existUser = new User();
				existUser.setId(rs.getInt("id"));
				existUser.setUsername(rs.getString("username"));
				existUser.setPassword(rs.getString("password"));
				existUser.setSex(rs.getString("sex"));
				existUser.setTelephone(rs.getString("telephone"));
				existUser.setEmail(rs.getString("email"));
				existUser.setIntroduce(rs.getString("introduce"));
				return existUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MyJdbcUtils.releaseAll(rs,stmt, conn);
		}
		return null;
	}
}
