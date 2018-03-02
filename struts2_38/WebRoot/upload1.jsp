<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>单文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<s:actionerror />
  	<s:fielderror />
    <form action="${ pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">
    	姓名：<input type="text" name="name" /><br/>
    	文件：<input type="file" name="upload" /><br/>
    	文件：<input type="file" name="upload" /><br/>
    	<input type="submit" value="保存" />
    </form>
  </body>
</html>
