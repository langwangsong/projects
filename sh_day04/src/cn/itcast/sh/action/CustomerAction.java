package cn.itcast.sh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.sh.domain.Customer;
import cn.itcast.sh.service.CustomerService;

/**
 * 客户的Action
 * @author Mr_lang
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//模型驱动使用的对象
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	/**
	 * 查询所有客户的执行方法：findAll
	 */
	public String findAll(){
		CustomerService cs = new CustomerService();
		List<Customer> list = cs.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}
}
