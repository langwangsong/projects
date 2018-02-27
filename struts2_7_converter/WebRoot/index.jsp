<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XXX网站的主页</title>
</head>
<body>
	<c:if test="${ sessionScope.user==null }">
		<a href="${ pageContext.request.contextPath }/regist.jsp">注册</a>
		<a href="${ pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	<c:if test="${ sessionScope.user!=null }">
		欢迎：${ sessionScope.user.username }
		<a href="${ pageContext.request.contextPath }/logout">注销</a>
	</c:if>
	<hr/>
	<h1>这是主页</h1>
	
</body>
</html>