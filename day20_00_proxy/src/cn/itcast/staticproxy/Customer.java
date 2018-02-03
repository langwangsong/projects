package cn.itcast.staticproxy;
//消费者：我们
public class Customer {
	public static void main(String[] args) {
		Saler s = new Saler();//找到一个代理商
		s.sale();
	}
}
