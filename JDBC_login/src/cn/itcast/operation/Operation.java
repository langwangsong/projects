package cn.itcast.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.iacats.entity.User;
import cn.itcast.utils.DBUtils;

public class Operation {
	public User findUser(String name,String pwd){
		Connection conn = null;
		//Statement stmt=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		User u = null;
		try{
			conn = DBUtils.getConn();
			/*stmt = conn.createStatement();
			String sql = "select * from users where name='"+name+"'and password = '"+pwd+"'";
			rs = stmt.executeQuery(sql);*/
			String sql = "select * from users where name=? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name); // 给？ 赋值， 1 代表给第一个？ 赋值
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
			System.out.println(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return u;
	}
}
