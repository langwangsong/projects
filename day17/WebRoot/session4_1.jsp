<%@page import="cn.itcast.listener2.Bean2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>session的钝化和活化</h3>
	<%
		Bean2 b2 = new Bean2();
		b2.setUsername("妹妹");
		//吧JavaBean存入到域对象中
		session.setAttribute("b2",b2);
	%>
	<h3>可以从域对象中获取值</h3>
	${ b2.username }
</body>
</html>