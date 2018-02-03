<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
	<h3>订单详情</h3>
	<table border="1" width="638">
		<tr>
			<th>书名</th>
			<th>数量</th>
			<th>金额</th>
		</tr>
		<c:forEach items="${items }" var="o" varStatus="vs">
			<tr class="${ vs.index%2==0?'odd':'even' }">
				<td>
					<img width="83" height="117" src="${pageContext.request.contextPath }/files/${ o.book.path }/${ o.book.filename }" />
					${o.book.name }
				</td>
				<td>${o.quantity }</td>
				<td>${o.price }</td>
			 </tr>
		</c:forEach>
	</table>
	<a href="javascript:history.back()">返回</a>
  </body>
</html>
