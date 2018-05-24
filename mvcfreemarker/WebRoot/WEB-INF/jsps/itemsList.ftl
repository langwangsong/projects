<#assign picPath="http://localhost:8003/ssmImg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="mvcfreemarker/item/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>商品图片</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<#list itemsList as item>
<tr>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td>
	<img id='imgSize1ImgSrc' src='${picPath }${item.pic }'  height="100" width="100" />
	</td>
	<td></td>
	<td>${item.detail }</td>
	
	<td><a href="mvcfreemarker/items/editItem.do?id=${item.id}">修改</a></td>

</tr>
</#list>

</table>
</form>
</body>

</html>