package cn.itcast.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.itcast.dao.OrdernumDao;
import cn.itcast.dao.impl.OrdernumDaoImpl;
import cn.itcast.domain.Ordernum;

//订单生成器
public class OrdernumGenerator {
	private static OrdernumDao dao = new OrdernumDaoImpl();
	public synchronized static String genOrdernum(){
		//得到当前日期
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String prefix = df.format(now)+"";
		StringBuffer sb = new StringBuffer(prefix);
		//按照当前日期查询数据库
		int serialNum = 1;
		Ordernum ordernum = dao.findOrdernum(prefix);
		//有对应的日期：取出编号+1--->返回，更新数据库
		if(ordernum!=null){
			serialNum = ordernum.getSerialNum()+1;
			ordernum.setSerialNum(serialNum);
			dao.updateOrdernum(ordernum);
		}
		else{//没有对应的日期：直接插入数据库，编号为1
			ordernum = new Ordernum();
			ordernum.setPrefix(prefix);
			ordernum.setSerialNum(1);
			dao.insertOrdernum(ordernum);
		}
		//组织订单序号。00000001  8位
		for(int i=0;i<8-(serialNum+"").length();i++){
			sb.append("0");
		}
		sb.append(serialNum);
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(genOrdernum());
	}
}
