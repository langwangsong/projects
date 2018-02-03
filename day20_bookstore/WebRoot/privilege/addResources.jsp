<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>添加资源</h3>
	<form action="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=addResource" method="post">
		<table border="1" width="438">
			<tr>
				<td>资源名称</td>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<td>资源的URI</td>
				<td><input name="uri" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
  </body>
</html>
