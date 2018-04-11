<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[在校学生管理]</td>
   
    <td width="57%"align="right">
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">班级</td>
    <td width="10%" align="center">QQ</td>
    <td width="10%" align="center">联系电话</td>
  	<td width="5%" align="center">编辑</td>
  	<td width="5%" align="center">查看</td>
  </tr>
  <s:iterator value="list" var="s" status="status">
  <tr class="tabtd2">
	<td align="center"><s:property value="#s.sname" /></td>
    <td align="center"><s:property value="#s.classes.cname" /></td>
    <td align="center"><s:property value="#s.qq" /></td>
    <td align="center"><s:property value="#s.telephone" /></td>
    <td align="center"><a href="editRole.html"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"></a></td>
	<td align="center"><a href="editRole.html"><img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"></a></td>
  </tr>
  </s:iterator>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第<s:property value="currentPage" />/<s:property value="totalPage" />页</span>&nbsp;&nbsp;
    	<span>总记录数：<s:property value="totalCount" /></span>&nbsp;&nbsp;
    	<span>每页显示：<s:property value="pageSize" /></span>&nbsp;&nbsp;
        <span>
        	<s:if test="currentPage!=1">
	        	<a href="${pageContext.request.contextPath}/student_findByPage.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/student_findByPage.action?currentPage=<s:property value="currentPage-1" />">[上一页]</a>&nbsp;&nbsp;
            </s:if>
            <s:iterator begin="1" end="totalPage" var="i">
            	<s:if test="currentPage == #i">
            		<s:property value="#i"/>
            	</s:if>
            	<s:else>
            		<a href="${pageContext.request.contextPath}/student_findByPage.action?currentPage=<s:property value="#i" />"><s:property value="#i"/></a>
            	</s:else>
            </s:iterator>
            <s:if test="currentPage!=totalPage">
	            <a href="${pageContext.request.contextPath}/student_findByPage.action?currentPage=<s:property value="currentPage+1" />">[下一页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/student_findByPage.action?currentPage=<s:property value="totalPage" />">[尾页]</a>
            </s:if>
        </span>
    </td>
  </tr>
</table>
</body>
</html>
