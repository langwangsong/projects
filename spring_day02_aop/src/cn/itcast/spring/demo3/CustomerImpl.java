package cn.itcast.spring.demo3;

public class CustomerImpl implements CustomerDao {

	@Override
	public void add() {
		System.out.println("添加订单...");
	}

	@Override
	public void delete() {
		System.out.println("删除订单...");
	}

	@Override
	public void update() {
		System.out.println("修改订单...");
	}

	@Override
	public void find() {
		System.out.println("查询订单...");
	}

}
