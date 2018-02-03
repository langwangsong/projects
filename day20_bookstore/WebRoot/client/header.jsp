<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>XXX网站</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/main.css">
  	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/util.js"></script>
  </head>
  
  <body>
    	<br/>
    	<h2>欢迎光临</h2>
    	<br/>
    	<!-- 后台登录位置 -->
    	<a href="${ pageContext.request.contextPath }">首页</a>
    	<c:if test="${ sessionScope.customer == null }">
	    	<a href="${ pageContext.request.contextPath }/client/login.jsp">登录</a>
	    	<a href="${ pageContext.request.contextPath }/client/regist.jsp">注册</a>
    	</c:if>
    	<c:if test="${ sessionScope.customer != null }">
    		欢迎您：${ sessionScope.customer.username }
    		<a href="${ pageContext.request.contextPath }/client/ClientServlet?op=logout">注销</a>
    	</c:if>
    	<a href="${ pageContext.request.contextPath }/client/ClientServlet?op=showSelfOrders">我的订单</a>
    	<a href="${ pageContext.request.contextPath }/client/showCart.jsp">购物车</a>
    	<br/>

   	
