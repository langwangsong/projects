<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>资源列表</h3>
	<a href="${ pageContext.request.contextPath }/privilege/addResources.jsp">添加</a>
	<table border="1" width="838">
			<tr>
				<th>名称</th>
				<th>URI</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ resources }" var="r" varStatus="vs">
				<tr class="${ vs.index%2==0?'odd':'even' }">
					<td>${ r.name }</td>
					<td>${ r.uri }</td>
					<td>
						[<a href="javascript:alert('略')">修改</a>]
						[<a href="javascript:alert('略')">删除</a>]
					</td>
				</tr>
			</c:forEach>
		</table>
  </body>
</html>
