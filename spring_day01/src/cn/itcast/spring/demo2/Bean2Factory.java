package cn.itcast.spring.demo2;
/**
 * Bean2的静态工厂
 * @author Mr_lang
 *
 */
public class Bean2Factory {
	public static Bean2 getBean2(){
		System.out.println("Bean2的工厂被调用");
		return new Bean2();
	}
}
