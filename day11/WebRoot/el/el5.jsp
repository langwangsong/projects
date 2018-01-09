<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>传统的方式获取请求的参数</h3>
	<%= request.getParameter("username") %>
	<h3>EL 提供了内置对象，param，可以使用param获取到请求的参数</h3>
	${ param.username }
	${ paramValues.username[0] }
	${header["user-agent"] }
	${headerValues["user-agent"][0] }
	<h3>获取全局的初始化参数</h3>
	${ initParam.encoding }
</body>
</html>