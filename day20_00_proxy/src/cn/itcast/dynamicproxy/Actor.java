package cn.itcast.dynamicproxy;

public class Actor implements Human {

	@Override
	public void sing(float money) {
		System.out.println("拿到钱："+money+",开始唱歌");
	}

	@Override
	public void dance(float money) {
		System.out.println("拿到钱："+money+",开始跳舞");
	}

}
