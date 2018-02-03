<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>用户列表</h3>
	<a href="${ pageContext.request.contextPath }/privilege/addUsers.jsp">添加</a>
	<table border="1" width="438">
			<tr>
				<th>登录名</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${ users }" var="u" varStatus="vs">
				<tr class="${ vs.index%2==0?'odd':'even' }">
					<td>${ u.username }</td>
					<td>
						[<a href="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=grantRole2UserUI&userId=${u.id}">分配角色</a>]
						[<a href="javascript:alert('略')">修改</a>]
						[<a href="javascript:alert('略')">删除</a>]
					</td>
				</tr>
			</c:forEach>
		</table>
  </body>
</html>
