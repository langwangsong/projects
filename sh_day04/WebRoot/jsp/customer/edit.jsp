<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改客户</h1>
	<s:form action="customer_update" namespace="/" method="post" theme="simple">
		<s:hidden name="cid" value="%{model.cid}"/>
		<table border="1" width="400">
			<tr>
				<td>客户名称</td>
				<td><s:textfield name="cname" value="%{model.cname}"/></td>
			</tr>
			<tr>
				<td>客户年龄</td>
				<td><s:textfield name="age" value="%{model.age}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"/></td>
			</tr>	
		</table>
	</s:form>
</body>
</html>