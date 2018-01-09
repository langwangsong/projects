<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>获取Cookie的值</h3>
	<%
		Cookie [] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			if(c.getName().equals("lasttime")){
				out.print(c.getValue());
			}
		}
	}
	%>
	<h3>使用cookie的内置对象取值</h3>
	${ cookie.lasttime.name }
	${ cookie.lasttime.value }
	<h3>使用pageContext内置对象</h3>
	${ pageContext.request.contextPath }
</body>
</html>