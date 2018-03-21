package cn.itcast.spring.demo2;

import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDao {

	public void save() {
		System.out.println("Dao中的保存方法 ...");
	}
	
}
