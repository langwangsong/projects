<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setAttribute("msg", "妹妹");
		session.setAttribute("msg", "小风");
	%>
	<h3>从域对象中获取值,(如果key不存在，获取的null)</h3>
	<%= request.getAttribute("msg") %>
	<h3>使用EL表达式取值,(如果key不存在，获取的"")</h3>
	${ requestScope.msg }
	${ requestScope["msg"] }
	<h3>从session中获取值</h3>
	${ sessionScope.msg }
	<h3>EL表达式简写方式</h3>
	${ msg }
</body>
</html>