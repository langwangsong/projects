<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="60%" cellpadding="5">
		<% 
			for(int i=0;i<5;i++){
		%>
			<tr>
			<%
				for(int j=0;j<5;j++){		
			%>
				<td>1</td>
			<%
				}
			%>
				
			</tr>			
		<%
			}
		%>

		
	</table>
</body>
</html>