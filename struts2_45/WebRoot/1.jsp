<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>struts2控制标签</title>
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
  		test :OGNL 表达式
  		在OGNL表达式中，字符串使用双引号引起来
  	 -->
  	<s:if test='#grade=="A"'>优秀</s:if>
  	<s:elseif test='#grade=="B"'>良好</s:elseif>
  	<s:else>尚需努力</s:else>
  	<hr/>
  	<!-- 
  		property:value不指定，默认输出栈顶
  	
  		iterator:非常重要
  			作用：实现遍历迭代，类似JSTL中的c:foreach
  			value :OGNL表达式
  			var:指定一个key值。遍历的过程中，会把当前元素以var指定的key存放到contextMap中
  				可以不指定。会把当前遍历的元素存放到root中。（ValueStack.push(元素)）
  			status:指定一个key值，引用一个对象，放在了contextMap中。该对象记录着当前遍历的元素属性
  				int genderIndex():当前对象的索引。从0开始
  				int getCount():当前对象的顺序。从1开始
  				boolean isFirst():是否是第一个元素
  				boolean isLast():是否是最后一个元素
  				boolean isOdd():是否是奇数
  				boolean isEven():是否是偶数
  			begin:从那个开始
  			end:结束索引
  			step:步长。默认是1
  	 -->
  	 <!-- 遍历：字符串数组 
  	 	s=aa
  	 	s=bb
  	 	s=cc
  	 -->
  	 <s:iterator value="strs" var="s">
  	 	<s:property value="#s"/>
  	 </s:iterator>
  	 <hr/>
  	 <s:iterator value="list1">
  	 	<s:property/>
  	 </s:iterator>
  	 <hr/>
  	 <s:iterator value="map" var="me">
  	 	<s:property value="#me.key" />==<s:property value="#me.value"/>
  	 </s:iterator>
  	 <hr/>

  	 <table border="1" width="438">
  	 	<tr>
  	 		<th>索引</th>
  	 		<th>序号</th>
  	 		<th>第一个</th>
  	 		<th>最后一个</th>
  	 		<th>奇数</th>
  	 		<th>偶数</th>
  	 		<th>姓名</th>
  	 		<th>性别</th>
  	 		<th>城市</th>
  	 		<th>生日</th>
  	 	</tr>
  	 	<s:iterator value="list2" var ="s" status="status">
  	 		<tr bgcolor="<s:property value='#status.odd?"#c3f3c3":"#f3c3f3"'/>">
  	 			<td><s:property value="#status.index"/></td>
	  	 		<td><s:property value="#status.count"/></td>
	  	 		<td><s:property value="#status.first"/></td>
	  	 		<td><s:property value="#status.last"/></td>
	  	 		<td><s:property value="#status.odd"/></td>
	  	 		<td><s:property value="#status.even"/></td>
  	 			<td><s:property value="#s.name"/></td>
  	 			<td><s:property value='#s.gender=="1"?"男":"女"'/></td>
  	 			<td><s:property value="#s.city"/></td>
  	 			<td><s:property value="#s.birthday"/></td>
  	 		</tr>	
  	 	</s:iterator>
  	 </table>
  	 <hr/>
  	<s:debug></s:debug>
  </body>
</html>
