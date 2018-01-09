package cn.itcast.operation;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import cn.itcast.entity.User;
import cn.itcast.util.DBUtils;

public class TestCRUD2 {
	@Test // 查询所有的用户信息
	public void testSelectAll() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			conn = DBUtils.getConn();
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
			//4、执行sql语句，并返回结果
			rs = stmt.executeQuery("select * from users");
			//5、 处理结果
			list =new ArrayList<User>();
			while(rs.next()){
				User u =new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
				list.add(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		for(User u:list){
			System.out.println(u);
		}
	}
	@Test
	public void testAddUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			conn = DBUtils.getConn();
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
		   //4、执行sql语句，并返回结果
			int i = stmt.executeUpdate("insert into users values(4,'feiqing','1234165','feiqing@126.com','1990-7-9')");
			if(i>0){
				System.out.println("添加成功");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		//6、关闭资源
	}
	@Test
	public void testDeleteUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =	null;
		List<User> list = null;
		try {
			conn = DBUtils.getConn();
			//3、得到执行SQL语句的Statement对象
			stmt = conn.createStatement();
		   //4、执行sql语句，并返回结果
			int i = stmt.executeUpdate("delete from users where id = 4");
			if(i>0){
				System.out.println("删除成功");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		//6、关闭资源
	}
}
