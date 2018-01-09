<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>测试pagecontext对象</h3>
	<%
		pageContext.setAttribute("msg", "妹妹");
		request.setAttribute("msg", "小风");
		pageContext.setAttribute("msg", "向杰", PageContext.REQUEST_SCOPE);
	%>		
	<%= pageContext.getAttribute("msg") %>
	<%= request.getAttribute("msg") %>
	<%= pageContext.getAttribute("msg", PageContext.REQUEST_SCOPE) %>
	<h3>全域查找</h3>
	<%= pageContext.findAttribute("msg") %>
</body>
</html>