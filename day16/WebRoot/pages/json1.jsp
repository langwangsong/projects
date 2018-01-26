<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//定义json
	//var person = {"name":"张三","age":18};
	//alert(person.name);
	//alert(person.age);
	//var person2 = [{"name":"张三"},{"name":"王五"}];
	//alert(person2[1].name);
	//var person3 = {"stu":[{"name":"赵六","age":20},{"name":"刘","age":23}]};
	//alert(person3.stu[0].name);
	//创建XMLHTTPRequest对象的兼容浏览器方式
	function run(){
		//先创建XMLHTTPRequest对象
		var xhr = new createXMLHttpRequest();
		//先连接服务器（连接Servlet）调用open（"GET"，"请求地址"，true）
		xhr.open("GET", "${pageContext.request.contextPath}/json1", true);
		xhr.send(null);
		//使用onreadystatechange事件监听XMLHTTPRequest状态的改变，是4说明状态响应已经结束，获取响应的内容
		xhr.onreadystatechange = function(){
		//如果状态是4，说明响应结束了，响应成功
			if(xhr.readyState == 4 && xhr.status == 200){
			//获取响应的内容。如果响应的是字符串，可以responseText结束内容
			var result = xhr.responseText;
			//写入到h3标签中
			//没有使用eval函数执行
			var p = eval("("+result+")");
			alert(p.name);
			}
		};
	}
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
	<button onclick="run()" >点击</button>
</body>
</html>