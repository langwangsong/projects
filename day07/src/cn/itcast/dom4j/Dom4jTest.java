package cn.itcast.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {
	@Test
	public void run1() throws DocumentException{
		/**
		 * 1、创建解析器的对象SAXReader
		 * 2、解析xxx.xml的文档，返回Document文档
		 * 3、现货区根节点（DOM4J的解析必须先获取根节点）
		 * 4、调用一些方法来获取到子节点机器文本内容
		 */
		//创建解析
		SAXReader reader = new SAXReader();
		//解析book3.xml的文档
		Document document = reader.read("src/book3.xml");
		//先获取根节点
		Element root = document.getRootElement();
		//打印根节点的标签名称
		//System.out.println(root.getName());
		
		//获取根节点下图书的子节点 elements获取的某个节点下左右的子节点，返回list集合  
		List<Element> books = root.elements("书");
		//循环遍历
		/*for(Element book :books){
			//System.out.println(book.getName());
			
			//获取书名的子节点    element获取某个节点下的第一个子节点，返回的是Element元素对象
			Element bname = book.element("书名");
			//获取书名中间的文本内容  getText() 获取节点中间的文本内容
			System.out.println(bname.getText());
		}*/
		//通过下标值获取指定的节点
		Element book = books.get(0);
		/*//获取书节点的属性对象
		Attribute attr = book.attribute("出版社");
		//获取属性的值
		System.out.println(attr.getValue());*/
		//System.out.println(book.attributeValue("出版社"));
		System.out.println(book.elementText("作者"));
	}
	/**
	 * 测试XPATH的语法
	 * @throws DocumentException 
	 */
	@Test 
	public  void run2() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book3.xml");
		//Node root = document.selectSingleNode("/书架/书/作者");
		List<Node> list = document.selectNodes("//作者");
		System.out.println(list.get(0).getName()+list.get(0).getText());
		
	}
}
