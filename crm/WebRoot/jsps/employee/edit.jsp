<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
       <a href="javascript:document.getElementById('form1').submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="javascript:history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:form action="employee_update" method="post" namespace="/" theme="simple" id="form1">
	<s:hidden name="eid" value="%{model.eid }"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="ename" value="%{model.ename }"></s:textfield></td>
	    <td>性别：</td>
	    <td><s:radio list="{'男','女'}" name="sex" value="%{model.sex }"></s:radio></td>
	  </tr>
	  <tr>
	    <td width="10%">出生日期：</td>
	    <td width="20%"><input type="text" name="birthday" id="birthday" value="<s:date name='model.birthday' format='yyyy-MM-dd'/>"></input></td>
	    <td width="8%">入职时间：</td>
	    <td width="62%"><input type="text" name="joinDate" id="joinDate" value="<s:date name='model.joinDate' format='yyyy-MM-dd'/>"></input></td>
	  </tr>
	  <tr>
	    <td width="10%">用户名：</td>
	    <td width="20%"><s:textfield name="username" value="%{model.username }"></s:textfield></td>
	    <td width="8%">密码：</td>
	    <td width="62%"><s:password name="password" value="%{model.password }" showPassword="true"></s:password></td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%"><s:select name="department.did" value="%{model.department.did }" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"></s:select> </td>
	    <td width="8%">编号：</td>
	    <td width="62%"><s:textfield name="eno" value="%{model.eno }"></s:textfield></td>
	  </tr>
	</table>
</s:form>
</body>
</html>
