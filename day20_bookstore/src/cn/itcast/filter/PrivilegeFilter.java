package cn.itcast.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.Resource;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.PrivilegeService;
import cn.itcast.service.impl.PrivilegeServiceImpl;
//权限过滤器
public class PrivilegeFilter extends AbstractFilter {
	private PrivilegeService ps = new PrivilegeServiceImpl();
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		//判断有没有登录，没有登录就去登录
		User user = (User) session.getAttribute("user");
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/passport/login.jsp");
			return;
		}
		//定义一个Set，存储用户可以访问的资源对象
		Set<Resource> canVisitResources = new HashSet<Resource>(0);//resource：name:uri
		//查询用户拥有的角色
		List<Role> roles = ps.findUserById(user.getId()+"").getRoles();
		if(roles!=null){
			//查询角色中可以访问的资源
			for (Role r : roles) {
				List<Resource> res = ps.findRoleById(r.getId()+"").getResources();
				canVisitResources.addAll(res);
			}
			//用户当前访问的资源：request.getRequestURI();
			String uri = request.getRequestURI();//   /day20_bookstore/manage/index.jsp
			uri = uri.replace(request.getContextPath(), ""); //      /manage/index.jsp
			String queryString = request.getQueryString();   //获取查询字符串。？后面的内容。如果没有，返回null
			uri = uri + (queryString == null ? "" : ("?"+queryString));
			//对比：当前的资源在不在访问的范围：不在，没有权限，不放行|在，放行
			boolean hasPermission = false; //没有权限
			for (Resource r : canVisitResources) {
				if(uri.equals(r.getUri())){
					hasPermission = true;
					break;
				}
			}
			if(!hasPermission){//不在，没有权限
				response.getWriter().write("您没有权限");
			}else{//在：放行
				chain.doFilter(request, response);
			}
		}else{
			response.getWriter().write("请联系您的管理员");
		}
	}

}
