<%@page import="cn.itcast.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>把表单的数据封装User对象中</h3>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
%>
<%= user.getUsername() %>

<h3>Model1数据的封装</h3>
<jsp:useBean id="u" class="cn.itcast.domain.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<jsp:getProperty property="username" name="u"/>
<jsp:getProperty property="password" name="u"/>

</body>
</html>















