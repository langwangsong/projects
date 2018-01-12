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
<c:if test="${ not empty existUser }">
	<h4>主页</h4>
	<h3>欢迎：${sessionScope.existUser.username }</h3>
</c:if>
<c:if test="${empty existUser }">
	<h3><a href="${ pageContext.request.contextPath }/login.jsp">登录页面</a></h3>
</c:if>
</body>
</html>