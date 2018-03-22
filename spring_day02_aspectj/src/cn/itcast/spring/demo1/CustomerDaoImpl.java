package cn.itcast.spring.demo1;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void add() {
		System.out.println("添加客户...");
	}

	@Override
	public void delete() {
		System.out.println("删除客户...");
	}

	@Override
	public int update() {
		System.out.println("修改客户...");
		return 100;
	}

	@Override
	public void find() {
		System.out.println("查找客户...");
		//int d = 10/0;
	}

}
