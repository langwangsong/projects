<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>session的监听属性的状态的改变</h3>
	<%
		session.setAttribute("msg","妹妹");
		session.setAttribute("msg","meimei");
		session.removeAttribute("msg");
	%>
</body>
</html>