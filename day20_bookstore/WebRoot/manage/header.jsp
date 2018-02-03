<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/main.css">
  	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/util.js"></script>
  </head>
  
  <body>
    	<br/>
    	<h2>后台管理</h2>
    	<c:if test="${ sessionScope.user==null }">
    		<a href="${ pageContext.request.contextPath }/passport/login.jsp">登录</a>
    	</c:if>
    	<c:if test="${ sessionScope.user!=null }">
    		当前用户：
    		${ sessionScope.user.username }<a href="javascript:alert('略')">注销</a>
    	</c:if>
    	<br/>
    	<!-- 后台登录位置 -->
    	<a href="${ pageContext.request.contextPath }/manage/addCategory.jsp">添加分类</a>
    	<a href="${ pageContext.request.contextPath }/manage/ManageServlet?op=listCategories">查询分类</a>
    	<a href="${ pageContext.request.contextPath }/manage/ManageServlet?op=addBookUI">添加书籍</a>
    	<a href="${ pageContext.request.contextPath }/manage/ManageServlet?op=listBooks">查询书籍</a>
    	<a href="">订单管理</a>
    	<br/>
   	权限管理：
   		<a href="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=listResources">资源管理</a>
   		<a href="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=listRoles">角色管理</a>
   		<a href="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=listUsers">用户管理</a>
   		<br/><br/>
