<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>添加用户</h3>
	<form action="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=addUser" method="post">
		<table border="1" width="438">
			<tr>
				<td>用户名称</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
  </body>
</html>
