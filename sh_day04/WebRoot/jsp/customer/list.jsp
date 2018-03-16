<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function showDetail(cid){
		// alert(cid);
		var but = document.getElementById("but"+cid);
		var tab = document.getElementById("tab"+cid);
		if(but.value == "订单详情"){
					// 创建异步对象:
				var xhr = createXmlHttp();
				// 设置监听:
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){
						if(xhr.status == 200){
							var data = xhr.responseText;
							var json = eval("("+data+")");
							
							for(var i= 0 ;i<json.length;i++){
								tab.innerHTML += "<tr><td>"+json[i].oid+"</td><td>"+json[i].addr+"</td></tr>";
							}
						}
					}
				}
				
				// 打开链接:
				xhr.open("GET","${ pageContext.request.contextPath}/order_findByCid.action?cid="+cid,true);
				// 发送数据:
				xhr.send(null);
				but.value = "关闭";
		}else{
			but.value = "订单详情";
			tab.innerHTML = "";
		}
	}
	
	
	function createXmlHttp(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }
	
		return xmlHttp;
	 }
</script>
</head>
<body>
	
	<h1>显示客户信息：</h1>
	<table border="1" width="800">
		<tr>
			<td colspan="5" align="right"><a href="${pageContext.request.contextPath }/jsp/customer/add.jsp">添加</a></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>年龄</th>
			<th>操作</th>
			<th>订单详情</th>
		</tr>
		<s:iterator value="list" var="c">
			<tr>
				<td><s:property value="#c.cid"/></td>
				<td><s:property value="#c.cname"/></td>
				<td><s:property value="#c.age"/></td>
				<td>
					<a href='${pageContext.request.contextPath }/customer_edit?cid=<s:property value="#c.cid"/>'>修改</a> 
					<a href='${pageContext.request.contextPath }/customer_delete?cid=<s:property value="#c.cid"/>'>删除</a>
				</td>
				<td>
					<input id="but<s:property value="#c.cid"/>" type="button" value="订单详情" onclick='showDetail(<s:property value="#c.cid"/>)' />
					<table width="100%" id='tab<s:property value="#c.cid"/>'></table>	
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>