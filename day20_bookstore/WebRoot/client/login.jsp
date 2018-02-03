<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
	<h3>用户登录</h3>
	<form action="${ pageContext.request.contextPath }/client/ClientServlet?op=login" method="post">
		<table border="1" width="438">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${URLDecoder.decode(cookie.loginInfo.value,'UTF-8')}" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="remember" ${cookie.loginInfo==null?'':'checked="checked"'} />记住用户名</td>
				<td>
					<input type="text" name="captcha" />验证码<br/>
					<img id="img1" src="${pageContext.request.contextPath }/client/ClientServlet?op=genCaptcha" />	
					<a href="javascript:change()">看不清，换一张</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="登录" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function change(){
			var imgObj = document.getElementById("img1");
			imgObj.src = "${ pageContext.request.contextPath }/client/ClientServlet?op=genCaptcha&time="+new Date().getTime();
		}
	</script>
  </body>
</html>
