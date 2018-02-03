package cn.itcast.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.itcast.manage.domain.Category;
import cn.itcast.service.ManageService;
import cn.itcast.service.impl.ManageServiceImpl;

public class ManageServiceImplTest {
	private ManageService s = new ManageServiceImpl();
	@Test
	public void testAddCategory() {
		Category c = new Category();
		c.setName("测试分类名称");
		c.setDescription("这是测试");
		s.addCategory(c);
	}

	@Test
	public void testFindCategoryById() {
		Category c = s.findCategoryById("1");
		assertNotNull(c);//期望c（实际值）不为 null
		c = s.findCategoryById("10000");
		assertNull(c);
	}

	@Test
	public void testFindAllCategories() {
		List<Category> cs = s.findAllCategories();
		assertEquals(1,cs.size());//实际值和期望值应该相等
	}

	@Test
	public void testIsCategoryExist() {
		boolean b = s.isCategoryExist("java编程类");
		assertFalse(b);//不在
		b = s.isCategoryExist("测试分类名称");
		assertTrue(b);
	}

}
