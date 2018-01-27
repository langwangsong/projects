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
	<h2>门户网站</h2>
	<h3>网站的Logo</h3>
	<c:if test="${ empty existUser }">
		<h4><a href="${ pageContext.request.contextPath }/pages/login.jsp">登录</a></h4>
	</c:if>
	<c:if test="${ not empty existUser }">
		<h4>亲，欢迎您  ${ existUser.nickname }</h4>
	</c:if>	
	
	<h3>新闻1</h3>
	<h3>新闻2</h3>
	<h3>新闻3</h3>
</body>
</html>