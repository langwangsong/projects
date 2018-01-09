<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>支付页面</h3>
	<% 
		Map<String,Integer> cart = (Map<String,Integer>)session.getAttribute("cart");
		if(cart!=null){
			Set<String> names = cart.keySet();
			for(String name:names){
	%>
		<h4>您购买的商品的名称为：<%= name %>,数量为：<%= cart.get(name) %> </h4>
	<%
			}
		}
	%>
</body>
</html>