<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<s:fielderror></s:fielderror>
	<form action="${pageContext.request.contextPath }/regist" method="post">
		<table border="1" width="338">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="username" value="${ username }" />
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="text" name="password" value="${password }"/>
				</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td>
					<input type="text" name="email" value="${email }" />
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td>
					<input type="text" name="birthday" value="${birthday }" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>