<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//判断用户名是否存在
	function checkName(){
		//先创建XMLHTTPRequest对象
		var xhr = new createXMLHttpRequest();
		//先连接服务器（连接Servlet）调用open（"GET"，"请求地址"，true）
		xhr.open("POST", "${pageContext.request.contextPath}/check", true);
		//注意：如果是POST请求，必须设置请求头的信息
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//发送参数，用户输入的值
		var username = document.getElementById("nameId").value;
		xhr.send("username="+username);
		//使用onreadystatechange事件监听XMLHTTPRequest状态的改变，是4说明状态响应已经结束，获取响应的内容
		xhr.onreadystatechange = function(){
		//如果状态是4，说明响应结束了，响应成功
			if(xhr.readyState == 4 && xhr.status == 200){
			//获取响应的内容。如果响应的是字符串，可以responseText结束内容
			var result = xhr.responseText;
			//写入到h3标签中
			document.getElementById("uSpan").innerHTML = result;
			}
		};
	}
	//创建XMLHTTPRequest对象的兼容浏览器方式
	function createXMLHttpRequest(){
		try{
			return new XMLHttpRequest;
		}catch(e){
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXobject("Microsoft.XMLHTTP");
				}catch(e){
					alert("大哥！您这是什么浏览器呀");
				}
			}
		}
	}
</script>
</head>
<body>
	<h3>注册的页面</h3>
	<form action="" method="post">
		姓名：<input type="text" name="username" id="nameId" onblur="checkName()" />
		<span id="uSpan"></span><br/>
		密码：<input type="password" name="password"/><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>