<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户的列表页面</h3>
	<table border="1" width="50%" cellpadding="5">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
	<c:forEach var="user" items="${ requestScope.uList }" varStatus="vs">
		<tr align="center">
			<td>${ vs.count }</td>
			<td>${ user.username }</td>
			<td>${ user.password }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/updateServlet?username=${ user.username }">修改</a>
				<a href="${ pageContext.request.contextPath }/deleteServlet?username=${ user.username }">删除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>