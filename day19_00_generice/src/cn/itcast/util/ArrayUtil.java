package cn.itcast.util;

public class ArrayUtil {
	//定义一个静态方法，实现数组任意两个指定位置上的元素交换
	/**
	 * 交换数据指定位置上的元素
	 * @param t 数组，非基本类型的
	 * @param index1 索引
	 * @param index2 索引
	 */
	public static <T> void exchange(T[] t,int index1,int index2){
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
	}
	//翻转
	public static <T> void reverse(T [] t){
		/*for (int i = 0; i < t.length / 2; i++) {
			T temp = t[i];
			t[i] = t[t.length - i -1];
			t[t.length - i - 1] = temp;
		}*/
		int startIndex = 0;
		int endIndex = t.length - 1;
		while(startIndex < endIndex){
			exchange(t,startIndex,endIndex);
			startIndex++;
			endIndex--;
		}
	}
}
