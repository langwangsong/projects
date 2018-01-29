<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>文件上传</h3>
	<form action="${pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
		文件描述：<input type="text" name="filedesc" /><br/>
		文件上传：<input type="file" name="myfile" /><br/>
		<input type="submit" value="上传" />
	</form>
</body>
</html>