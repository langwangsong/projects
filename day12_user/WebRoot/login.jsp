<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
		<h3>登录页面</h3>
		<h4><font color="red">${requestScope["msg"] }</font></h4>
		<form action="${pageContext.request.contextPath}/login" method="post">
			姓名:<input type="text" name="username" value="${cookie.remember.value}"><br/>
			密码:<input type="password" name="password"><br/>
			记住用户名:<input type="checkbox" name="remember" value="remember_ok"><br/>
			验证码：<input type="text" name="formCode" /><img src="${ pageContext.request.contextPath }/checkcode" onclick="changecode(this)" ><br/>
			<input type="submit" value="登陆">
		</form>

  </body>
  <script type="text/javascript">
  	function changecode(who){
  		//who就到表的是img元素对象
  		who.src="${ pageContext.request.contextPath }/checkcode?time="+new Date().getTime();
  	}
  </script>
</html>
