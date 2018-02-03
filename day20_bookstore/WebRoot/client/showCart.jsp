<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
	<h3>您购买的商品如下</h3>
	<c:if test="${ empty sessionScope.cart.items }">
		<h2 class="required">老大，您没有购买任何商品，请先购买</h2>
	</c:if>
	<c:if test="${ !empty sessionScope.cart.items }">
		<table border="1" width="538">
			<tr>
				<th>书名</th>
				<th>作者</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ sessionScope.cart.items }" var="me" varStatus="vs">
				<tr class="${ vs.index%2==0?'odd':'even' }">
					<td>${ me.value.book.name }</td>
					<td>${ me.value.book.author }</td>
					<td>${ me.value.book.price }</td>
					<td><input type="text" id="q1" value="${ me.value.quantity }" onchange="changeNum('${ me.key }','${ me.value.quantity }')" /></td>
					<td>${ me.value.price }</td>
					<td>
						[<a href="javascript:deleteOne(${ me.key })">删除</a>]
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right">
					总数量：${ sessionScope.cart.totalQuantity }
					总金额：${ sessionScope.cart.totalPrice }
					<a href="${ pageContext.request.contextPath }/client/ClientServlet?op=genOrder">去结算</a>
				</td>
			</tr>
		</table>
		<a href="javascript:deleteAll()">清空购物车</a>
	</c:if>
	<script type="text/javascript">
		function deleteOne(bookid){
			var sure = window.confirm("确定要删除该项吗？");
			if(sure){
				window.location.href="${ pageContext.request.contextPath }/client/ClientServlet?op=delOneItem&bookid="+bookid;
			}
		}
		function deleteAll(){
			var sure = window.confirm("确定要清空购物车吗？");
			if(sure){
				window.location.href="${ pageContext.request.contextPath }/client/ClientServlet?op=delAllItem";
			}
		}
		function changeNum(bookid,oldquantity){
			var quantity = document.getElementById("q1").value;
			//判断
			if(!/^[1-9][0-9]*$/.test(quantity)){
				alert("请输入正确数量");
				return;
			}
			var sure = window.confirm("确定要修改数量为"+quantity+"吗？");
			if(sure){
				//提交
				window.location.href="${ pageContext.request.contextPath }/client/ClientServlet?op=changeQuantity&bookid="+bookid+"&quantity="+quantity;
			}else{
				//改为原来的值
				document.getElementById("q1").value = oldquantity;
			}
		}
	</script>
  </body>
</html>
