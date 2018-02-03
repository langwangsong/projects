<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/client/header.jsp" %>
   	所有分类：
   		<c:forEach items="${ cs }" var="c">
   			<a href="${ pageContext.request.contextPath }/client/ClientServlet?op=listBooksByCategory&categoryid=${c.id}">${ c.name }</a>&nbsp;&nbsp;
   		</c:forEach>
   		<br/><br/>
   		<hr/>
   		<br/>
		<table>
			<tr>
				<c:forEach items="${page.beanList}" var="b">
					<td>
						<img width="83" height="117" src="${pageContext.request.contextPath }/files/${ b.path }/${ b.filename }" />
						<br/>书名：${ b.name }<br/>
						作者：${ b.author }<br/>
						单价：${ b.price }<br/>
						<a href="${pageContext.request.contextPath }/client/ClientServlet?op=showBookDetails&bookid=${b.id}" >详情</a>
					</td>
				</c:forEach>
			</tr>		
		</table>
		<%@ include file="/commons/page.jsp" %>
	</body>
</html>