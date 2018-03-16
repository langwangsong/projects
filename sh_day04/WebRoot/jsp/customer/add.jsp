<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>添加客户</h1>
	<form action="${pageContext.request.contextPath }/customer_save" method="post">
		<table border="1" width="400">
			<tr>
				<td>客户名称</td>
				<td><input type="text" name="cname"/></td>
			</tr>
			<tr>
				<td>客户年龄</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加"/></td>
			</tr>	
		</table>
	</form>
</body>
</html>