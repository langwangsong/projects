package cn.itcast.spring.demo1;

public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("添加用户");
	}

	@Override
	public void update() {
		System.out.println("更新用户");
	}

	@Override
	public void delete() {
		System.out.println("删除用户");
	}

	@Override
	public void find() {
		System.out.println("查找用户");
	}

}
