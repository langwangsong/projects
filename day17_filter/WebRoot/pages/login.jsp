<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>登录页面</h3>
	<h4>${ msg }</h4>
	<form action="${ pageContext.request.contextPath }/login" method="post">
		姓名：<input type="text" name="username" /><br/>
		密码：<input type="password" name="password" /><br/>
		<input type="checkbox" name="autoLogin" value="auto_ok" />自动登录
		<input type="submit" value="登录" />
	</form>
</body>
</html>