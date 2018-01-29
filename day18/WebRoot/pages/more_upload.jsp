<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//生成文件的上传项
	function createFile(){
		var div = document.getElementById("divId");
		div.innerHTML += "<div><input type='file' name='myfile'></input><input type='button' value='删除' onclick='del(this)' /></div>";
	}
	//删除文件的上传项
	function del(who){
		//who代表的是删除按钮
		//先获取到删除按钮的爹
		var div = who.parentNode;
		//获取删除按钮的爹的爹，使用爹的爹删除掉删除按钮的爹
		div.parentNode.removeChild(div);
	}
</script>
</head>
<body>
	<h3>多文件的上传</h3>
	<form action="${ pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
		<input type="button" value="添加" onclick="createFile()" />
		<input type="button" value="上传" />
		<div id="divId">
		
		</div>
	</form>
</body>
</html>