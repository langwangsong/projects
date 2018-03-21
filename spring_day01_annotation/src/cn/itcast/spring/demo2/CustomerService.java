package cn.itcast.spring.demo2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")
@Scope("prototype")
public class CustomerService {
	/*@Autowired //默认按照类型装配
	@Qualifier("customerDao")*/
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	public void save(){
		System.out.println("业务层的保存的方法...");
		customerDao.save();
	}
}
