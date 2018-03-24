package cn.itcast.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.ssh.domain.Book;
import cn.itcast.ssh.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHDemo {
	@Resource(name="bookService")
	private BookService bookService;
	/**
	 * 测试修改
	 */
	@Test
	public void test1(){
		Book book = new Book();
		book.setBid(1);
		book.setBname("Spring");
		book.setPrice(62d);
		bookService.updata(book);
	}
	/**
	 * 查询一个对象
	 */
	@Test
	public void demo2(){
		Book book = bookService.findById(1);
		System.out.println(book);
	}
	/**
	 * 删除一个对象
	 */
	@Test
	public void demo3(){
		Book book = bookService.findById(1);
		bookService.delete(book);
	}
	/**
	 * 查询多个对象
	 */
	@Test
	public void demo4(){
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	/**
	 * 查询多个：QBC
	 */
	@Test
	public void demo5(){
		List<Book> books = bookService.findAllByCriteria();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	/**
	 * 查询多个分页：QBC
	 */
	@Test
	public void demo6(){
		List<Book> books = bookService.findAllByCriteriaPage();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	/**
	 * 查询多个：命名查询
	 */
	@Test
	public void demo7(){
		List<Book> books = bookService.findAllByNamedQuery();
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
