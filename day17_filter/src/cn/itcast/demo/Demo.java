package cn.itcast.demo;

public class Demo {
	public static void main(String[] args) {
		//创建麻雀
		MaQue mq = new MaQue();
		mq.fly();
		mq.eat();
		System.out.println("==============");
		MaQueWrapper mqw = new MaQueWrapper(mq);
		mqw.fly();
		mqw.eat();
	}
}
