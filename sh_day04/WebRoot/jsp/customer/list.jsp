<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>显示客户信息：</h1>
	<table border="1" width="600">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>年龄</th>
			<th>操作</th>
			<th>订单详情</th>
		</tr>
		<s:iterator value="list" var="c">
			<tr>
				<td><s:property value="#c.cid"/></td>
				<td><s:property value="#c.cname"/></td>
				<td><s:property value="#c.age"/></td>
				<td><a href="">修改</a> <a href="">删除</a></td>
				<td><input type="button" value="订单详情" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>