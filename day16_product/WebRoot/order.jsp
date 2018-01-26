<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function createOrder(){
		//需要让表单提交
		document.getElementById("orderForm").submit();
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
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="cart.jsp">&nbsp;购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单
					</div>
					<!-- 点击提交按钮，需要把orderForm表单提交到servlet中
						需要修改action路径
					 -->
					<form id="orderForm" action="${ pageContext.request.contextPath }/createOrder" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td><table width="100%" border="0" cellspacing="0">
										<tr>
											<td><img src="images/buy2.gif" width="635" height="38" />
												<!-- 修改登陆后的提示信息 -->
												<p>您好：${ existUser.username } ！欢迎您来到商城结算中心</p>
											</td>
										</tr>
										<tr>
											<td><table cellspacing="1" class="carttable">
													<tr>
														<td width="10%">序号</td>
														<td width="40%">商品名称</td>
														<td width="10%">价格</td>
														<td width="10%">类别</td>
														<td width="10%">数量</td>
														<td width="10%">小计</td>

													</tr>
												</table> 
												
													<table width="100%" border="0" cellspacing="0">
														<!-- 从购物车中获取到购买的商品信息，展示 -->
														<!-- 处理合计 -->
														<c:set value="0" var="sum"></c:set>
														<c:forEach var="entry" items="${ cart }" varStatus="vs">
															<tr>
																<td width="10%">${ vs.count }</td>
																<td width="40%">${ entry.value.name }</td>
																<td width="10%">${ entry.value.price }</td>
																<td width="10%">${ entry.value.category }</td>
																<td width="10%"><input name="text" type="text"
																	value="${ entry.value.buyCount }" style="width:20px" readonly="readonly"/>
																</td>
																<td width="10%">${ entry.value.price * entry.value.buyCount }</td>
															</tr>
															<!-- 处理合计 -->
															<c:set var="sum" value="${sum + entry.value.price *  entry.value.buyCount }"></c:set>
														</c:forEach>
													</table>
													

												<table cellspacing="1" class="carttable">
													<tr>
														<td style="text-align:right; padding-right:40px;">
															<font style="color:#FF0000">合计：&nbsp;&nbsp;${ sum }元</font>
														<!-- 添加隐藏域，把合计偷偷传递过来 -->
														<input type="hidden" name="totalprice" value="${ sum }" />
														</td>
													</tr>
												</table>

												<p>
													收货地址：<input name="receiverAddress" type="text" value=""
														style="width:350px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input
														name="receiverName" type="text" value=""
														style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 联系方式：<input type="text" name="receiverPhone"
														value="" style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;<a
														href="#"></a>

												</p>
												<hr />
												<!-- 提交订单 -->
												<p style="text-align:right">
													<img src="images/gif53_029.gif" width="204" height="51"
														border="0" onclick="createOrder();"/>
												</p>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
