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
    <s:textfield name="username" value="%{name}" label="姓名"></s:textfield>	
  	<hr/>
  	<table border="1" width="438">
  		<tr>
  			<th>姓名</th>
  			<th>年龄</th>
  			<th>城市</th>
  		</tr>
  		<s:iterator value="users.{?#this.age>10}" var="user">
  			<tr>
	  			<td>${user.name }</td>
	  			<td>${user.age }</td>
	  			<td>${user.city }</td>
  			</tr>
  		</s:iterator>
  	</table>
  	<hr/>
  	<table border="1" width="438">
  		<tr>
  			<th>姓名</th>
  		</tr>
  		<!-- users.{name} 取出list中元素的name属性，成立新的集合{"aaa","bbb","ccc"}-->
  		<s:iterator value="users.{name}" var="user">
  			<tr>
	  			<td>${user }</td>
  			</tr>
  		</s:iterator>
  	</table>
  </body>
</html>
