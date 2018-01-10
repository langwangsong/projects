<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>forEach标签库</h3>
	<c:forEach var="i" begin="1" end="20" step="2" varStatus="vs">
		<!-- ${ i } -->
		<!-- ${ vs.count } -->
		<!-- ${ vs.index } -->
		<!-- ${ vs.first } -->
		${ vs.current }
	</c:forEach>
	<br/>
	<%
		List<String> list= new ArrayList<String>();
		list.add("妹妹");
		list.add("小风");
		list.add("小花");
		request.setAttribute("list", list);
	%>
	<!-- 增强for循环 -->
	<c:forEach var="str" items="${ list }">
		${ str }
	</c:forEach>
	<br/>
	<!-- 迭代Map集合 -->
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("aaa","妹妹");
		map.put("bbb","小风");
		map.put("ccc","小花");
		request.setAttribute("map", map);
	%>
	<c:forEach var="entry" items="${ map }">
		${ entry.key } -- ${ entry.value }
	</c:forEach>
</body>
</html>