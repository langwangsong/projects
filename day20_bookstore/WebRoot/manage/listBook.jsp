<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>所有分类</h3>
	<c:if test="${ empty page.beanList }">
		<h2 class="required">老大，没有任何书</h2>
	</c:if>
	<c:if test="${ !empty page.beanList }">
		<table border="1" width="738">
			<tr>
				<th>图片</th>
				<th>书名</th>
				<th>作者</th>
				<th>单价</th>
				<th>描述</th>
				<th>所属分类</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ page.beanList }" var="b" varStatus="vs">
				<tr class="${ vs.index%2==0?'odd':'even' }">
					<td><img width="83" height="117" src="${pageContext.request.contextPath }/files/${ b.path }/${ b.filename }" /></td>
					<td>${ b.name }</td>
					<td>${ b.author }</td>
					<td>${ b.price }</td>
					<td>${ b.description }</td>
					<td>${ b.category.name }</td>
					<td>
						[<a href="javascript:alert('略')">修改</a>]
						[<a href="javascript:alert('略')">删除</a>]
					</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 分页有关 -->
		<%@ include file="/commons/page.jsp" %>
	</c:if>
  </body>
</html>
