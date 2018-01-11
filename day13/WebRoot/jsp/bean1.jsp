<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Model1封装数据</h3>
<form action="${ pageContext.request.contextPath }/jsp/suc.jsp" method="post">
	姓名：<input type="text" name="username" /><br/>
	密码：<input type="password" name="password" /><br/>
	<input type="submit" value="注册" />
</form>


<h3>Model2封装数据</h3>
<form action="${ pageContext.request.contextPath }/user" method="post">
	姓名：<input type="text" name="username" /><br/>
	密码：<input type="password" name="password" /><br/>
	<input type="submit" value="注册" />
</form>

<h3>Model2封装数据（封装int类）</h3>
<form action="${ pageContext.request.contextPath }/user" method="post">
	姓名：<input type="text" name="username" /><br/>
	密码：<input type="password" name="password" /><br/>
	年龄：<input type="text" name="age" /><br/>
	<input type="submit" value="注册" />
</form>

<h3>Model2封装数据（封装Date类型）</h3>
<form action="${ pageContext.request.contextPath }/user" method="post">
	姓名：<input type="text" name="username" /><br/>
	密码：<input type="password" name="password" /><br/>
	年龄：<input type="text" name="age" /><br/>
	生日：<input type="text" name="birthday" /><br/>
	<input type="submit" value="注册" />
</form>

</body>
</html>