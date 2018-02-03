package cn.itcast.staticproxy;
//销售商：代理类
public class Saler  {
	private Lenovo lenovo;//生产商
	public Saler(){
		if(lenovo==null){
			lenovo = new Lenovo();
		}
	}
	public Lenovo getLenovo() {
		return lenovo;
	}
	public void setLenovo(Lenovo lenovo) {
		this.lenovo = lenovo;
	}
	public void sale() {
		lenovo.genericComputer();
	}
	
}
