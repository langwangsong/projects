package cn.itcast.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Resource;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.PrivilegeService;
import cn.itcast.service.impl.PrivilegeServiceImpl;
import cn.itcast.util.MyBeanUtil;
//权限模块的控制器
public class PrivilegeServlet extends HttpServlet {
	private PrivilegeService privilegeService = new PrivilegeServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("listResources".equals(op)){
			listResources(request,response);
		}else if("addResource".equals(op)){
			addResource(request,response);
		}else if("listRoles".equals(op)){
			listRoles(request,response);
		}else if("addRole".equals(op)){
			addRole(request,response);
		}else if("grantResource2RoleUI".equals(op)){
			grantResource2RoleUI(request,response);
		}else if("grantResource2Role".equals(op)){
			grantResource2Role(request,response);
		}else if("listUsers".equals(op)){
			listUsers(request,response);
		}else if("addUser".equals(op)){
			addUser(request,response);
		}else if("grantRole2UserUI".equals(op)){
			grantRole2UserUI(request,response);
		}else if("grantRole2User".equals(op)){
			grantRole2User(request,response);
		}
	}
	//用户重新分配角色
	private void grantRole2User(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到用户
		String userId = request.getParameter("userId");
		//哪些角色
		String [] roleIds = request.getParameterValues("roleIds");
		privilegeService.grantRole2User(userId,roleIds);
		request.setAttribute("message", "分配角色成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//转向用户分配角色
	private void grantRole2UserUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到用户
		String userId = request.getParameter("userId");
		User user = privilegeService.findUserById(userId);
		//查询所有的角色
		List<Role> roles = privilegeService.findAllRoles();
		request.setAttribute("user", user);
		request.setAttribute("roles", roles);//包含该用户的角色
		request.getRequestDispatcher("/privilege/grantRole2User.jsp").forward(request, response);
}
	//添加用户
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = MyBeanUtil.fillBean(request, User.class);
		privilegeService.addUser(user);
		response.sendRedirect(request.getContextPath()+"/privilege/PrivilegeServlet?op=listUsers");
	}
	//展现所有的用户
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users =privilegeService.findAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/privilege/listUsers.jsp").forward(request, response);
	}
	//给角色分配id
	private void grantResource2Role(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到角色
		String roleId = request.getParameter("roleId");
		//哪些资源
		String [] resIds = request.getParameterValues("resIds");
		privilegeService.grantResource2Role(roleId,resIds);
		request.setAttribute("message", "分配资源成功");
		request.getRequestDispatcher("/manage/message.jsp").forward(request, response);
	}
	//展现界面：资源分配角色
	private void grantResource2RoleUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到角色
		String roleId = request.getParameter("roleId");
		//查询所有的资源
		List<Resource> resources = privilegeService.findAllResources();
		Role role = privilegeService.findRoleById(roleId);
		request.setAttribute("role", role);
		request.setAttribute("resources", resources);//包含该角色可访问的资源
		request.getRequestDispatcher("/privilege/grantResource2Role.jsp").forward(request, response);
	}
	//添加角色
	private void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Role role = MyBeanUtil.fillBean(request, Role.class);
		privilegeService.addRole(role);
		response.sendRedirect(request.getContextPath()+"/privilege/PrivilegeServlet?op=listRoles");
	}
	//列出所有角色
	private void listRoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> roles =privilegeService.findAllRoles();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/privilege/listRoles.jsp").forward(request, response);
	}
	//保存资源
	private void addResource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resource resource = MyBeanUtil.fillBean(request, Resource.class);
		privilegeService.addResource(resource);
		response.sendRedirect(request.getContextPath()+"/privilege/PrivilegeServlet?op=listResources");
	}
	//列出所有的资源列表
	private void listResources(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Resource> resources =privilegeService.findAllResources();
		request.setAttribute("resources", resources);
		request.getRequestDispatcher("/privilege/listResources.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
