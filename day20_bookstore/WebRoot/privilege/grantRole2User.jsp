<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>用户分配角色</h3>
	用户名：${user.username}<hr/>
	<form action="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=grantRole2User&userId=${user.id}" method="post">
		<table border="1" width="438">
			<tr>
				<th>所有角色</th>
				<th>已分配角色</th>
			</tr>
			<tr>
				<td>
					<c:forEach items="${roles }" var="r">
						<input type="checkbox" name="roleIds" value="${r.id }" />${r.name }<br/>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${ user.roles }" var="r">
						${ r.name }<br/>
					</c:forEach>
				</td>
			</tr>
		</table>
		<input type="button" value="保存" onclick="checkSubmit()" />
	</form>
	<script type="text/javascript">
		function checkSubmit(){
			var roleIds = document.getElementsByName("roleIds");
			//有没有选择
			var selected = false;
			for(var i=0;i<roleIds.length;i++){
				if(roleIds[i].checked){
					selected = true;
					break;
				}
			}
			if(!selected){
				alert("请选择角色");
				return;
			}
			//提交
			document.forms[0].submit();
		}
	</script>
	</body>
</html>