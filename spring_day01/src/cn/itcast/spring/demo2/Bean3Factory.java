package cn.itcast.spring.demo2;
/**
 * Bean3的实例工厂
 * @author Mr_lang
 *
 */
public class Bean3Factory {
	public Bean3 getBean3(){
		System.out.println("Bean3的工厂被调用了");
		return new Bean3();
	}
}
