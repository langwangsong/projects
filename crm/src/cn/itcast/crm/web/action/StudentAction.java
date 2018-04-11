package cn.itcast.crm.web.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.domain.Student;
import cn.itcast.crm.service.StudentService;

/**
 * 在校学生的Action类
 * @author Mr_lang
 *
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	private Student student = new Student();
	@Override
	public Student getModel() {
		return student;
	}
	@Resource(name="studentService")
	private StudentService studentService;
	//接收当前页数
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 分页查询的方法findByPage
	 */
	public String findByPage(){
		PageBean<Student> pageBean = studentService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findByPage";
	}
}
