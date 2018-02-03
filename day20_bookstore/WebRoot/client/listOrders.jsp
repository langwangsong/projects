<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
	<h3>订单列表</h3>
	<table border="1" width="638">
		<tr>
			<th>订单号</th>
			<th>数量</th>
			<th>金额</th>
			<th>状态</th>
			<th>下单时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${orders }" var="o" varStatus="vs">
			<tr class="${ vs.index%2==0?'odd':'even' }">
				<td>${o.ordernum }</td>
				<td>${o.totalQuantity }</td>
				<td>${o.totalPrice }</td>
				<td>
					<c:choose>
						<c:when test="${o.status==0 }">
							未付款
							<a href="${ pageContext.request.contextPath }/client/PayUIServlet?ordernum=${o.ordernum}">去付款</a>
						</c:when>
						<c:when test="${o.status==1 }">
							已付款
						</c:when>
						<c:when test="${o.status==2 }">
							已发货
						</c:when>
					</c:choose>
				</td>
				<td>${o.createDate }</td>
				<td>
					<a href="${ pageContext.request.contextPath }/client/ClientServlet?op=showOrderDetail&ordernum=${o.ordernum}">详情</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
