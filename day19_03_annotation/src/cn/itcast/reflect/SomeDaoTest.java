package cn.itcast.reflect;

public class SomeDaoTest {
	@MyTest
	public void testSave(){
		System.out.println("save方法测试了");
	}
	@MyTest(timeout=10)//方法如果执行超过了10纳秒，也是失败的。测试的性能
	public void testUpdate(){
		System.out.println("update方法测试了");
	}
}
