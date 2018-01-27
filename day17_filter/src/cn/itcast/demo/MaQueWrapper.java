package cn.itcast.demo;
/**
 * 增强的类
 * @author Mr_lang
 *
 */
public class MaQueWrapper implements Bird {
	//麻雀
	private Bird b;
	public MaQueWrapper(Bird b){
		this.b=b;
	}
	//自己增强该方法，其他的方法都是麻雀在做，只有该方法自己修改的
	//MaQueWrapper和麻雀的类，就有一个方法不同
	public void fly() {
		//mq.fly();
		System.out.println("该方法给增强了");
	}
	public void eat() {
		b.eat();
	}
}
