<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>角色分配资源</h3>
	角色名称：${role.name}<hr/>
	<form action="${ pageContext.request.contextPath }/privilege/PrivilegeServlet?op=grantResource2Role&roleId=${role.id}" method="post">
		<table border="1" width="838">
			<tr>
				<th>所有资源</th>
				<th>已分配资源</th>
			</tr>
			<tr>
				<td>
					<c:forEach items="${resources }" var="res">
						<input type="checkbox" name="resIds" value="${res.id }" />${res.name }<br/>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${ role.resources }" var="res">
						${ res.name }<br/>
					</c:forEach>
				</td>
			</tr>
		</table>
		<input type="button" value="保存" onclick="checkSubmit()" />
	</form>
	<script type="text/javascript">
    	function checkSubmit(){
    		var resIds = document.getElementsByName("resIds");
    		//有没有选择
    		var selected = false;
    		for(var i=0;i<resIds.length;i++){
    			if(resIds[i].checked){
    				selected=true;
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