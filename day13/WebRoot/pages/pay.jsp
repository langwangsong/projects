<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>支付案例</h3>
	<form action="${ pageContext.request.contextPath }/accountpay" method="post">
		付款人：<input type="text" name="fromuser" /><br/>
		收款人：<input type="text" name="touser" /><br/>
		金    额：<input type="text" name="money" /><br/>
		<input type="submit" value="转账" /><br/>
	</form>
</body>
</html>