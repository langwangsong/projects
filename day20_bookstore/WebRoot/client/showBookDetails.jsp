<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
		<img width="83" height="117" src="${pageContext.request.contextPath }/files/${ book.path }/${ book.filename }" /><br/>
		${ book }<br/>
		<form 	onsubmit="return checkQuantity()" 
				action="${pageContext.request.contextPath }/client/ClientServlet?op=buyBook" method="post">
			<input type="hidden" name="bookid" value="${ book.id }" />
			数量：<input type="text" id="quantity" name="quantity" value="1" /><br/>
			<input type="submit" value="加入购物车" />
			<input type="button" value="返回" onclick="history.back()" />
		</form>
		<script type="text/javascript">
			//检查数量
			function checkQuantity(){
				var quantity = document.getElementById("quantity").value;
				//正则
				if(!/^[1-9][0-9]*$/.test(quantity)){
					alert("请输入正确数量");
					return false;
				}
			}
		</script>
	</body>
</html>