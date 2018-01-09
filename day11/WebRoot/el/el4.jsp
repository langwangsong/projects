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
		int n1=10;
		int n2=20;
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		User user = new User();
		user.setUsername("user");
		request.setAttribute("user", user);
	%>
	${ n1>n2 }
	${ n1 eq n2}
	${ empty user }
</body>
</html>