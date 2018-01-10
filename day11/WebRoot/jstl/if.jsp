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
	<h3>if签库</h3>
	<%
		int n1=10;
	request.setAttribute("n1", n1);
	%>
	<c:if test="${ n1 eq 20 }" var="i" >
		<font color="red"> n1=20</font>
	</c:if>
	<c:if test="${ n1 ne 20 }">
		<font color="blue"> n1!=20</font>
	</c:if>
	${ i }
</body>
</html>