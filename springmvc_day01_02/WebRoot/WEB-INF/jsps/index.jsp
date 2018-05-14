<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/save.do" method="post">
		姓名：<input type="text" name="username" id="username" /><br/>
		生日：<input type="text" name="birthday" id="birthday" /><br/>
		性别：<input type="text" name="sex" id="sex"/><br/>
		地址：<input type="text" name="address" id="address"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>	
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/receive.do" method="post">
		id:<input type="text" name="id" id="id"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/delete.do" method="post">
		id:<input type="checkbox" name="ids" id="id" value="1"/><br/>
		id:<input type="checkbox" name="ids" id="id" value="2"/><br/>
		id:<input type="checkbox" name="ids" id="id" value="3"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/receivePos.do" method="post">
		姓名：<input type="text" name="user.username" id="username" /><br/>
		生日：<input type="text" name="user.birthday" id="birthday" /><br/>
		性别：<input type="text" name="user.sex" id="sex"/><br/>
		地址：<input type="text" name="user.address" id="address"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>	
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/receiveList.do" method="post">
		姓名：<input type="text" name="users[0].username" id="username" /><br/>
		地址：<input type="text" name="users[0].address" id="address" /><br/>
		姓名：<input type="text" name="users[1].username" id="username"/><br/>
		地址：<input type="text" name="users[1].address" id="address"/><br/>
		<input type="submit" value="提交" /><br/>
	</form>	
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/receiveMap.do" method="post">
		姓名：<input type="text" name="maps['username']" id="username" /><br/>
		地址：<input type="text" name="maps['address']" id="address" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>	
	<hr color="blue" size="12" /> <br/>
	<form action="${pageContext.request.contextPath}/user/param.do" method="post">
		ID：<input type="text" name="myID" id="id" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>	
</body>
</html>