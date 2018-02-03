<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>添加角色</h3>
	<form action="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=addRole" method="post">
		<table border="1" width="438">
			<tr>
				<td>角色名称</td>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<td>角色描述</td>
				<td><input name="description" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
  </body>
</html>
