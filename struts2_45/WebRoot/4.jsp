<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>struts2数据标签3</title>
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
  ${name}
  	<table border="1" width="438">
  	 	<tr>
  	 		<th>索引</th>
  	 		<th>序号</th>
  	 		<th>第一个</th>
  	 		<th>最后一个</th>
  	 		<th>奇数</th>
  	 		<th>偶数</th>
  	 		<th>姓名</th>
  	 		<th>性别</th>
  	 		<th>城市</th>
  	 		<th>生日</th>
  	 	</tr>
  	 	<s:iterator value="list2" var ="s" status="status">
  	 		<tr bgcolor="<s:property value='#status.odd?"#c3f3c3":"#f3c3f3"'/>">
  	 			<td>${ status.index }</td>
	  	 		<td>${status.count }</td>
	  	 		<td>${status.first }</td>
	  	 		<td>${status.last}</td>
	  	 		<td>${status.odd }</td>
	  	 		<td>${status.even }</td>
  	 			<td>${s.name }</td>
  	 			<td>${s.gender=='1'?'男':'女' }</td>
  	 			<td>${s.city }</td>
  	 			<td><s:date name="#s.birthday" format="yyyy-MM-dd" /></td>
  	 		</tr>	
  	 	</s:iterator>
  	 </table>
  </body>
</html>
