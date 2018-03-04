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
    
    <title>struts2数据标签</title>
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
  	<!-- 
  		property:
  			作用：输出表达式的值到页面上
  			属性：
  				value:是一个OGNL表达式.默认值是：输出栈顶对象
  				default:如果OGNL表达式的值是一个null，输出默认值
  	 -->
  	 <s:property value="#grade"/>
  	 <s:property value="#grade1" default="没有"/>
  	 <s:property value='"<h1>abcdefg</h1>"' escapeHtml="false"/>
  	 <s:property/>
  	 <hr/>
  	 <!-- 
  	 	date:
  	 		作用： 对日期的数据进行格式化
  	 		属性：name，是一个OGNL表达式,要格式化的日期数据
  	 			format:SimpleDateFormat使用那些格式
  	  -->
  	  <s:property value="list2[0].birthday"/><br/>
  	  <s:date name="list2[0].birthday" format="yyyy-MM-dd"/>
  	  <hr/>
  	  <!-- 
  	  	action:
  	  		作用：在一个页面中，实现包含。包含的是另外一个动作的结果
  	  		属性：
  	  			name：动作的名称
  	  			executeResult:是否执行结果
  	   -->
  	  <s:action name="demo3" executeResult="true"></s:action>
  	  <hr/>
  	  <!-- 
  	  	a:
  	  		作用： 输出一个超链接
  	  	param:
  	  		作用：传递请求参数。get方式传递参数。对中文进行URL编码；URL重写。
  	  		属性：
  	  			name:参数名称，字符串
  	  			value:是一个OGNL表达式
  	   -->
  	   <a href="demo3">普通超链接</a>
  	   <s:a action="demo3"> 猛戳
  	   	<s:param name="username" value='"admin"'></s:param>
  	   	<s:param name="city" value='"北京"'></s:param>
  	   </s:a>
  	   <hr/>
  	   <!-- 
  	   	url:
  	   		作用：构造一个地址
  	   		属性：
  	   			action:动作名称
  	   			var:给运算结果一个名称，以该名称吧结果存到contextMap中
  	   		结合param标签来使用
  	    -->
  	    <s:url action="demo3" var="u1"></s:url>
  	    <a href="<s:property value="#u1" />">普通超链接</a>
  	<s:debug></s:debug>
  </body>
</html>
