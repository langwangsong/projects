<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CRM系统</title>
</head>

<frameset rows="90,*" framespacing="0px" frameborder="no">
	<frame src="${pageContext.request.contextPath}/jsps/frame/top.jsp" scrolling="no"/>
    <frameset id="main" cols="170,9,*" framespacing="0px" frameborder="no" >
        <frameset rows="30,*,40" framespacing="0px" frameborder="no" >
			<frame src="${pageContext.request.contextPath}/jsps/frame/left1.jsp" scrolling="no"/>
            <frame src="${pageContext.request.contextPath}/jsps/frame/left.jsp" scrolling="no"/>
            <frame src="${pageContext.request.contextPath}/jsps/frame/left2.jsp" scrolling="no"/>
        </frameset>
        <frame src="${pageContext.request.contextPath}/jsps/frame/control.jsp" scrolling="no"/>
        <frame src="${pageContext.request.contextPath}/jsps/frame/right.jsp" name="right" scrolling="no"/>
	</frameset>
</frameset>
</html>