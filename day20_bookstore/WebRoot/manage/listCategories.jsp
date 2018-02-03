<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>所有分类</h3>
	<c:if test="${ empty cs }">
		<h2 class="required">老大，没有任何分类</h2>
	</c:if>
	<c:if test="${ !empty cs }">
		<table border="1" width="438">
			<tr>
				<th>序号</th>
				<th>分类名称</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ cs }" var="c" varStatus="vs">
				<tr class="${ vs.index%2==0?'odd':'even' }">
					<td>${ vs.count }</td>
					<td>${ c.name }</td>
					<td>${ c.description }</td>
					<td>
						[<a href="javascript:alert('略')">修改</a>]
						[<a href="javascript:alert('略')">删除</a>]
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
  </body>
</html>
