<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新用户注册</title>
    <s:head/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <!-- 
   	 <form action="${pageContext.request.contextPath }/user/regist" method="post">
   	 	用户名：<input type="text" name="username" /><br/>
   	 	密码：<input type="password" name="password" /><br/>
   	 	性别：<input id="male" type="radio" name="gender" value="1"/><label for="male">男</label>
   	 		<input id="female" type="radio" name="gender" value="0"/><label for="female">女</label><br/>
   		籍贯：<select name="city">
   				<option value="">--请选择--</option>
   				<option value="北京" selected="selected">北京</option>
   				<option value="上海">上海</option>
   				<option value="天津">天津</option>
   			</select><br/>
   		爱好：<input type="checkbox" name="hobby" value="篮球" />篮球
   			<input type="checkbox" name="hobby" value="足球" />足球
   			<input type="checkbox" name="hobby" value="乒乓球" />乒乓球
   		<br/>
   		简介：<textarea rows="3" cols="38" name="description"></textarea><br/>
   		<input type="reset" value="重置"/>
   		<input type="submit" value="提交"/>
   	 </form>
   	 <hr/>
   	-->
   	 <!-- 
   	 	s:radio中的
   	 		list属性
		   	 	OGNL：创建list或map集合
		   	 		List:{元素1，元素2,...}
		   	 		Map：井号{key1:value1,key2:value2,...}
		   	 listKey:OGNL表达式。获取list指定的Map的元素的getKey方法
		   	 listValue:OGNL表达式。获取list指定的Map的元素的getValue方法
   	  -->
   	 <s:form action="regist" namespace="/user">
   	 	姓	名：<s:textfield name="username" label="用户名" requiredLabel="true"></s:textfield><br/>
   	 	密码：<s:password name="password" label="密码"></s:password><br/>
   	 	性别：<s:radio name="gender" list='#{"1":"男","0":"女"}' label="性别" value="0"></s:radio><br/>
   	 	籍贯：<s:select name="city" list='{"北京","上海","天津"}' label="籍贯" headerKey="" headerValue="--请选择--" value='"北京"'></s:select>
   	 	<br/>爱好：<s:checkboxlist name="hobby" list='{"篮球","足球","乒乓球"}' label="爱好"></s:checkboxlist>
   		<br/>简介：<s:textarea name="description" cols="38" rows="3" label="简介"></s:textarea>
   	 	<br/><s:reset value="重置"></s:reset>
   	 	<s:submit value="提交"></s:submit>
   	 </s:form>
  </body>
</html>
