<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 取contextMap中root中对象的属性，不用使用任何符号，直接写属性名即可 -->
  	<!-- 从根的栈顶依次查找，找到为止 -->
  	<s:property value="[1].name"/><br/>
  	<s:property value="s2.name"/><br/>
  	<s:property value="s3.name"/><br/>
  	<s:property value="name"/><br/>
    <s:debug></s:debug>
  </body>
</html>
