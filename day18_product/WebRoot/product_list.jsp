<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>
					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="images/productlist.gif" width="100%" height="38" />
								</div>

								<table cellspacing="0" class="booklist">
									
									<tr>
										<c:forEach var="p" items="${ page.beanList }">
										<td>
											<div class="divbookpic">
												<p>
													<a href="${ pageContext.request.contextPath }/initProduct?id=${p.id}"><img src="${pageContext.request.contextPath}${ p.imgurl}" width="115" height="129" border="0" /></a>
												</p>
											</div>
											<div class="divlisttitle">
												<a href="${ pageContext.request.contextPath }/initProduct?id=${p.id}">书名:${ p.name }<br />售价:${ p.price } </a>
											</div>
										</td>
										</c:forEach>
									</tr>
								</table>
								<div class="pagination">
									<ul>
										<c:if test="${ page.pageCode > 1 }">
											<li class="disablepage"><a href="${ pageContext.request.contextPath }/listByPage?pc=${ page.pageCode-1}">上一页</a></li>
										</c:if>
										<c:choose>
											<%-- 当前总页数小于等于10，说明没有10页，页码列表应该让begin=1,end=总页数 --%>
											<c:when test="${page.totalPage <=10 }">
												<c:set var="begin" value="1"></c:set>
												<c:set var="end" value="${ page.totalPage }"></c:set>
											</c:when>
											<%-- 说明总页数已经大于10，begin=当前页-5 end=当前页+4 --%>
											<c:otherwise>
												<c:set var="begin" value="${ page.pageCode - 5 }"></c:set>
												<c:set var="end" value="${ page.pageCode + 4 }"></c:set>
												<%-- 头部溢出（点击1到6页） --%>
												<c:if test="${ begin<1 }">
													<c:set var="begin" value="1"></c:set>
													<c:set var="end" value="10"></c:set>
												</c:if>
												<%-- 尾部溢出 --%>
												<c:if test="${ end > page.totalPage }">
													<c:set var="begin" value="${ page.totalPage - 9 }"></c:set>
													<c:set var="end" value="${ page.totalPage }"></c:set>
												</c:if>
											</c:otherwise>
										</c:choose>
										<c:forEach var="i" begin="${ begin }" end="${ end }" step="1">
											<c:if test="${ page.pageCode eq i }">
												<li class="current">${ i }</li>
											</c:if>
											<c:if test="${ page.pageCode ne i }">
												<li><a href="${ pageContext.request.contextPath }/listByPage?pc=${i}">${ i }</a></li>
											</c:if>
										</c:forEach>
										
										<c:if test="${ page.pageCode < page.totalPage }">
											<li class="nextPage"><a href="${ pageContext.request.contextPath }/listByPage?pc=${ page.pageCode+1}">下一页</a></li>
										</c:if>
									</ul>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
