<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD>
<STYLE>
.cla1 {
FONT-SIZE: 12px; COLOR: #4b4b4b; LINE-HEIGHT: 18px; TEXT-DECORATION: none
}
.login_msg{
	font-family:serif;
}
.login_msg .msg{
	background-color: #acf;
}
.login_msg .btn{
	background-color: #9be;
	width: 73px;
	font-size: 18px;
	font-family: 微软雅黑;
}
</STYLE>

<TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
</SCRIPT>
<META content="MSHTML 6.00.2600.0" name=GENERATOR></HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
	<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
		<tr>
			<td height="93"></td>
			<td></td>
		</tr>
		<tr>
			<td background="${pageContext.request.contextPath}/images/right.jpg"  width="740" height="412"></td>
			<td class="login_msg" width="400">
				<s:form action="employee_login" method="post" namespace="/" theme="simple">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/title.png" width="185" height="26"/><br/><br/>
					<s:actionerror/><br/>
					<s:fielderror></s:fielderror><br/>
					用户名：<s:textfield name="username" cssClass="msg" /><br/><br/>
					密&nbsp;&nbsp;码：<s:password name="password" cssClass="msg" /><br/><br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn" type="submit" value=" 登录 "/>
					
					<input class="btn" type="button" value=" 注册 " onclick="document.location='${pageContext.request.contextPath}/employee_registUI.action'"/>
					
				</s:form>
			</td>
		</tr>
	</table>
</div>
</BODY></HTML>