package cn.itcast.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.domain.User;
import cn.itcast.utils.MyJdbcUtils;

/**
 * 
 * 处理登录业务
 * @author Mr_lang
 *
 */
public class UserService {
	public User findByUser(String username,String password){
		/**
		 * 根据用户名和密码查询该用户
		 * 如果查到了，就返回User
		 * 否则，返回null
		 */
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try{
			//获取链接
			conn = MyJdbcUtils.getConn();
			//编写SQL语句
			String sql = "select * from users where username = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//释放资源
			MyJdbcUtils.releaseAll(rs ,stmt , conn);
		}
		return null;
	}
}
