<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="cn.itcast.el.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String [] arrs = {"妹妹","小风","香姐"};
		//需要先把数组存入到域对象中
		request.setAttribute("arrs", arrs);
	%>
	<h3>获取数组中的值</h3>
	${ requestScope.arrs[2] }
	<% 
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		request.setAttribute("user", user);
	%>
	<h3>从域对象中获取到user对象的属性值</h3>
	${ requestScope.user.username }
	<%
		Map<String,String> map = new HashMap<String,String>(); 
		map.put("one","妹妹");
		map.put("two","小风");
		request.setAttribute("map", map);
	%>
	<h3>从域对象中获取Map的属性值</h3>
	${ requestScope.map.one }
	${	map["two"] }
	
	<%
		List<User> uList = new ArrayList<User>();
		uList.add(new User("组名","123"));
		uList.add(new User("薛斌","456"));
		request.setAttribute("uList", uList);
	%>
	<h3>从域对象中获取List集合中User属性值</h3>
	${uList[0].username }
</body>
</html>