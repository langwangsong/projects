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
    <td width="39%" align="left">[部门管理]</td>
   
    <td width="57%"align="right">
       <a href="${pageContext.request.contextPath}/department_saveUI.action"><img src="${pageContext.request.contextPath}/images/button/tianjia.gif" /></a>
      
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
    <td width="6%" align="center">部门名称</td>
    <td width="7%" align="center">编辑</td>
    <td width="7%" align="center">删除</td>
  </tr>
  <s:iterator value="list" var="d" status="status">
  <s:if test="#status.count % 2 == 0">
	  <tr class="tabtd2">
  </s:if>
  <s:if test="#status.count % 2 != 0">
	  <tr class="tabtd1">
  </s:if>
	    <td align="center"><s:property value="#d.dname" /> </td>
	  	<td width="7%" align="center"><a href="${pageContext.request.contextPath}/department_edit.action?did=<s:property value="#d.did" />"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"></a></td>
		<td width="7%" align="center"><a href="${pageContext.request.contextPath}/department_delete.action?did=<s:property value="#d.did" />"><img src="${pageContext.request.contextPath}/images/button/delete.gif" class="img"></a></td>	  
	  </tr>
  </s:iterator>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="center">
    	<span>第<s:property value="currentPage" />/<s:property value="totalPage" />页</span>&nbsp;&nbsp;
    	<span>总的记录数：<s:property value="totalCount" /></span>&nbsp;&nbsp;
    	<span>每页显示：<s:property value="pageSize" />条记录</span>&nbsp;&nbsp;
        <span>
       		<s:if test="currentPage != 1">
	        	<a href="${pageContext.request.contextPath}/department_findByPage.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/department_findByPage.action?currentPage=<s:property value="currentPage-1" />">[上一页]</a>
            </s:if>
            <s:iterator begin="1" end="totalPage" var="i">
	           <s:if test="currentPage == #i">
	           		<s:property value="#i" />
	           </s:if>
	           <s:else>
	           		<a href="${pageContext.request.contextPath}/department_findByPage.action?currentPage=<s:property value="#i" />"><s:property value="#i" /></a>
	           </s:else>
            </s:iterator>
            <s:if test="currentPage != totalPage">
	            <a href="${pageContext.request.contextPath}/department_findByPage.action?currentPage=<s:property value="currentPage+1" />">[下一页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/department_findByPage.action?currentPage=<s:property value="totalPage" />">[尾页]</a>
       		</s:if>	
        </span>
    </td>
  </tr>
</table>
</body>
</html>
