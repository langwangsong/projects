<%@page import="cn.itcast.utils.MyCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.img1{
		width:140px;
		height:160px;
	}
	.img2{
		width:70px;
		height:80px;
	}
</style>
</head>
<body>
	<h3>商品列表</h3>
	<img class="img1" src ="/day10/img/1.jpg"><a href="/day10/servlet/Product?id=1">手电筒</a>
	<img class="img1" src ="/day10/img/2.jpg"><a href="/day10/servlet/Product?id=2">电话</a>
	<img class="img1" src ="/day10/img/3.jpg"><a href="/day10/servlet/Product?id=3">电视</a>
	<br/>
	<img class="img1" src ="/day10/img/4.jpg"><a href="/day10/servlet/Product?id=4">冰箱</a>
	<img class="img1" src ="/day10/img/5.jpg"><a href="/day10/servlet/Product?id=5">手表</a>
	<img class="img1" src ="/day10/img/6.jpg"><a href="/day10/servlet/Product?id=6">电脑</a>
	<h3>浏览记录</h3>
	<h4><a href="/day10/servlet/ClearProductServlet">清除浏览记录</a></h4>
	<%
		Cookie [] cookies = request.getCookies();
		Cookie cookie = MyCookieUtil.getCookieByName(cookies,"product");
		//说明已经找到cookie了，获取值，迭代数据
		if(cookie != null){
			String ids = cookie.getValue();
			String [] idArr = ids.split(",");
			for(String id :idArr){
	%>
				<img class="img2" src = "/day10/img/<%= id %>.jpg">
	<%
			}
		}
	%>
</body>
</html>