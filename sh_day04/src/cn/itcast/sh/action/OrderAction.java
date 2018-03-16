package cn.itcast.sh.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.sh.domain.Order;
import cn.itcast.sh.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 订单的Action
 * @author Mr_lang
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();
	@Override
	public Order getModel() {
		return order;
	}
	//接收cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 编写一个根据客户id查询订单的方法
	 * @throws IOException 
	 */
	public String findByCid() throws IOException{
		OrderService os = new OrderService();
		List<Order> orders = os.findByCid(cid);
		//转成JSON：{id:1,name:XXX},[{id:1,name:XXX},{id:1,name:XXX},{id:1,name:XXX},]
		//JSONlib:
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customer"});
		JSONArray jsonArray = JSONArray.fromObject(orders,jsonConfig);
		//System.out.println(jsonArray.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}
}
