<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
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
  	<%
  	ValueStack vs = ActionContext.getContext().getValueStack();
  	String s1 = vs.findString("name");//OGNL表达式
  	out.write(s1+"<br/>");
  	String s2 = vs.findString("#name");//OGNL表达式
  	out.write(s2+"<br/>");
  	%>
    <s:debug></s:debug>
  </body>
</html>
