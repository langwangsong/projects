<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	//修改商品的数量，id代表商品的主键，count代表要
	function changeCount(id,count){
		window.location.href="${pageContext.request.contextPath}/changeCartCount?id="+id+"&count="+count;
	}
</script>
</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.jpg" width="666" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td><img src="images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> 
												<!-- 显示购物车中的数据 -->
												<table width="100%" border="0" cellspacing="0">
													<c:forEach var="entry" items="${ cart }" varStatus="vs">
														<tr>
															<td width="10%">${vs.count}</td>
															<td width="30%">${entry.value.name }</td>
	
															<td width="10%">${entry.value.price }</td>
															<td width="20%">
																<input type="button" value='-' style="width:20px" onclick="changeCount('${ entry.value.id}','${ entry.value.buyCount - 1 }')" >
																<input name="text" type="text" value="${entry.value.buyCount}" style="width:40px;text-align:center" /> 
																<input type="button" value='+' style="width:20px" onclick="changeCount('${ entry.value.id}','${ entry.value.buyCount + 1 }')" >
															</td>
															<td width="10%">${entry.value.pnum}</td>
															<td width="10%">${entry.value.price*entry.value.buyCount}</td>
	
															<td width="10%"><a href="${pageContext.request.contextPath}/changeCartCount?id=${entry.value.id}&count=0"style="color:#FF0000; font-weight:bold">X</a></td>
														</tr>
													</c:forEach>
												</table>
												


											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;${total}元</font>
													</td>
												</tr>
											</table>
											<div style="text-align:right; margin-top:10px">
												<a href="${pageContext.request.contextPath}/listByPage"><img src="images/gwc_jx.gif" border="0" /> </a>

												&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="${pageContext.request.contextPath}/order.jsp"><img
													src="images/gwc_buy.gif" border="0" /> </a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
