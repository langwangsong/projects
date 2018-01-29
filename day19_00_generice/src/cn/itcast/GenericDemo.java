package cn.itcast;
/**
 * 泛型的声明定义在类上，只有实例方法使用
 * 
 * @author Mr_lang
 *
 * @param <T>
 */
public class GenericDemo<T> {
	//<T>声明反泛型类型，是有声明后才能使用；声明必须在返回值前面
	public  T find(){
		return null;
	}
	public void get(Class<T> clazz){
		
	}
	//静态方法都必须单独先声明后使用
	public static <T> T m1(){
		return null;
	}
	//可以一次声明好多的泛型
	public static <K,V> V get(K k){
		return null;
	}
}
