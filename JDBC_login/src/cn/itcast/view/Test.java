package cn.itcast.view;

import java.util.Scanner;

import cn.iacats.entity.User;
import cn.itcast.operation.Operation;

public class Test {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = input.nextLine();
		System.out.println("请输入密码");
		String pwd = input.nextLine();
		
		Operation opt = new Operation();
		User user = opt.findUser(name, pwd);
		if(user!=null){
			System.out.println("欢迎您："+user.getName());
		}else{
			System.out.println("用户名或密码错误");
		}
	}
}
