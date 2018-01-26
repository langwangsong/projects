<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/products/add.jsp";
	}
</script>
</HEAD>
<body>
	<br>
	<!-- 多条件查询功能 -->
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/findByWhere"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询 条 件</strong></td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">商品编号</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="id" size="15" value="${param.id }" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">类别：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select name="category" id="category">
										<option value="" selected="selected">--选择商品类加--</option>
										<option value="文学">文学</option>
										<option value="生活">生活</option>
										<option value="计算机">计算机</option>
										<option value="外语">外语</option>
										<option value="经营">经营</option>
										<option value="励志">励志</option>
										<option value="社科">社科</option>
										<option value="学术">学术</option>
										<option value="少儿">少儿</option>
										<option value="艺术">艺术</option>
										<option value="原版">原版</option>
										<option value="科技">科技</option>
										<option value="考试">考试</option>
										<option value="生活百科">生活百科</option>
									</select>
								</td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text"name="name" size="15" value="${param.name }" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">价格区间(元)：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text"name="minprice" value="${param.minprice }" size="10" value="" />- 
									<input type="text"name="maxprice" value="${param.maxprice }" size="10" value="" />
								</td>
							</tr>

							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong></td>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
						<!-- 添加删除按钮 -->
						<button type="button" id="delete" name="delete" value="&#28155;&#21152;"
							class="button_add" onclick="deleteSel()">删除
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="24%" >
									<!-- 表格的表头添加一个复选框 -->
									<input type="checkbox" id="selOrNo" name="selOrNo" onclick="selectAll()" />
								</td>								
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品数量</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>

								<td width="8%" align="center">删除</td>
							</tr>

							<c:forEach var="p" items="${pList }">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="3">
										<!-- 在数据的列表中添加复选框 -->
										<input type="checkbox" name="checkbox" value="${p.id }" />
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="23">${p.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.price }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.pnum }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${p.category }</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="${pageContext.request.contextPath}/initUpdate?id=${p.id}">
											<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" border="0" style="CURSOR: hand">
										</a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="#">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
<script type="text/javascript">
	// 全选|全不选功能
	function selectAll(){
		//获取到了selOrNo的元素的checked属性的值（true或者false）
		var flag = document.getElementById("selOrNo").checked;
		//直接获取到所有的复选框
		var checkboxes = document.getElementsByName("checkbox");
		for(var i=0;i<checkboxes.length;i++){
			//获取每一个复选框的元素对象
			var ch = checkboxes[i];
			//对象checked属性复制
			ch.checked=flag;
		}
	}
	//删除被选中的复选框
	//先获取哪些复选框被选中，如果被选中，把选中的id拼接成一个字符串，访问Servlet后台，删除id值
	function deleteSel(){
		var deleteUrl = "${pageContext.request.contextPath}/deleteSelect?";
		var checkboxes = document.getElementsByName("checkbox");
		for(var i=0;i<checkboxes.length;i++){
			//获取每一个复选框的元素对象
			var ch = checkboxes[i];
			//判断，如果ch的属性值是true，说明被选中了
			if(ch.checked){
				var id = ch.value;
				//拼接字符串
				deleteUrl += "id="+id+"&";
			}
		}
		deleteUrl = deleteUrl.substring(0, deleteUrl.length-1);
		// alert(deleteUrl);
		//完成跳转，访问Servlet   相当于超链接
		window.location.href = deleteUrl;
	}
</script>
</HTML>

