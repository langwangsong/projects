package cn.itcast.crm.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.domain.CourseType;
import cn.itcast.crm.domain.PageBean;
import cn.itcast.crm.service.CourseTypeService;

/**
 * 课程类别的Action
 * @author Mr_lang
 *
 */
public class CourseTypeAction extends ActionSupport implements ModelDriven<CourseType> {
	//模型驱动使用的类
	private CourseType courseType = new CourseType();
	@Override
	public CourseType getModel() {
		return courseType;
	}
	//注入课程类别的Service
	@Resource(name="courseTypeService")
	private CourseTypeService courseTypeService;
	//接收当前页数
	private int currentPage = 1;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 分页查询课程类别的执行方法：findByPage
	 */
	public String findByPage(){
		//接收当前的页
		//调用业务层查询数据
		PageBean<CourseType> pageBean = courseTypeService.findByPage(currentPage);
		//存入到值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		//页面跳转
		return "findByPage";
	}
	/**
	 * 跳转到添加页面的执行方法：saveUI
	 */
	public String saveUI() {
		return "saveUI";
	}
	/**
	 * 保存课程类别的执行方法：save
	 */
	public String save() {
		//调用业务层
		courseTypeService.save(courseType);
		return "saveSuccess";
	}
	/**
	 * 编辑课程类别的执行方法：edit
	 */
	public String edit(){
		courseType = courseTypeService.findById(courseType.getTid());
		return "editSuccess";
	}
	/**
	 * 次改课程类别的执行方法：update
	 */
	public String update(){
		courseTypeService.update(courseType);
		return "updateSuccess";
	}
	/**
	 * 课程类别的删除的执行方法：delete
	 */
	public String delete(){
		courseType = courseTypeService.findById(courseType.getTid());
		courseTypeService.delete(courseType);
		return "deleteSuccess";
	}
	/**
	 * 课程类别高级查询跳转的执行方法：serachUI
	 */
	public String serachUI(){
		return "serachUI";
	}
	//接收高级查询的参数
	private Integer tnumMax;//学时的最大值
	private Double tpriceMax;//学费的最大值
	
	public void setTnumMax(Integer tnumMax) {
		this.tnumMax = tnumMax;
	}

	public void setTpriceMax(Double tpriceMax) {
		this.tpriceMax = tpriceMax;
	}

	/**
	 * 高级查询的执行方法：search:QBC方式的高级查询
	 */
	/*public String search(){
		DetachedCriteria criteria = DetachedCriteria.forClass(CourseType.class);
		if(courseType.getTname()!=null && !"".equals(courseType.getTname())){
			criteria.add(Restrictions.like("tname", "%"+courseType.getTname()+"%"));
		}
		if(courseType.getTnum()!=null){
			criteria.add(Restrictions.ge("tnum", courseType.getTnum()));
		}
		if(tnumMax!=null){
			criteria.add(Restrictions.le("tnum", tnumMax));
		}
		if(courseType.getTprice()!=null){
			criteria.add(Restrictions.ge("tprice", courseType.getTprice()));
		}
		if(tpriceMax!=null){
			criteria.add(Restrictions.le("tprice", tpriceMax));
		}
		List<CourseType> list = courseTypeService.search(criteria);
		ActionContext.getContext().getValueStack().set("list", list);
		return "searchSuccess";
	}*/
	/**
	 * 高级查询带分页的执行方法：search:HQL方式
	 */
	public String search(){
		//调用业务层
		PageBean<CourseType> pageBean = courseTypeService.searchByHQL(courseType,tnumMax,tpriceMax,currentPage);
		return "searchSuccess";
	}
}
