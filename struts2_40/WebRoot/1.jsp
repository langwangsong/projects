<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <!-- s:property功能类似JSTL中c:out
    	作用：把value的值显示到页面上
    	value中编写的就是OGNL表达式
     -->
     <!-- 调用普通对象的实例方法 -->
    <s:property value='"abcdef".toUpperCase()'/><br/>
    <!-- 访问静态变量 -->
    <s:property value="@java.lang.Integer@MAX_VALUE"/><br/>
    <!-- 访问静态方法:struts2中默认禁用动态方法调用的
    	需要配置一个struts2的参数：struts.ognl.allowStaticMethodAccess=true
     -->
    <s:property value="@java.lang.Math@abs(-100)"/>
    <hr/>
    <!-- 从contextMap中根据key值获取对应的value值；使用井号 -->
    <s:property value="#s1"/><br/>
    <s:property value="#session.s2"/>
  </body>
</html>
