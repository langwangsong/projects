<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function requestJson(){
		//构造json对象
		var user = JSON.stringify({username:"张晓华",sex:"男",address:"北京"});
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/requestJson.do',
			contentType:'application/json;charset=UTF-8',
			data:user,
			success:function(data){
				alert(data);
			}
		})
	}
	function requestPo(){
		//构造json对象
		var user = JSON.stringify({username:"张晓华",sex:"男",address:"北京"});
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/user/requestPo.do',
			data:'username=张晓华&sex=男&address=北京',
			success:function(data){
				alert(data);
			}
		})
	}
</script>
</head>
<body>
	<input type="button" value="请求json，返回json" onclick="requestJson()" />
	<input type="button" value="请求PO，返回json" onclick="requestPo()" />
</body>
</html>