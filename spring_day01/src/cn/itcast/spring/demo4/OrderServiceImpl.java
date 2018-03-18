package cn.itcast.spring.demo4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 演示Bean的完整生命周期
 * @author Mr_lang
 *
 */
public class OrderServiceImpl implements OrderService,BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private String name;
	public OrderServiceImpl() {
		System.out.println("第一步：实例化Bean...");
	}
	public void save(){
		System.out.println("第九步：执行业务逻辑的save方法");
	}
	public void update(){
		System.out.println("第九步：执行业务逻辑的update方法");
	}
	public void setName(String name) {
		System.out.println("第二步：封装属性"+name);
		this.name = name;
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("第三步：Bean了解在Spring中配置的Bean的名称"+beanName);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("第四步：Bean了解Spring的工厂"+applicationContext);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("第六步：属性设置完成...");
	}
	public void setup(){
		System.out.println("第七步：执行手动配置的初始化的方法...");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("第十步：执行Spring中销毁方法");
	}
	public void teardown(){
		System.out.println("第十一步：执行手动配置的销毁的方法...");
	}
}
