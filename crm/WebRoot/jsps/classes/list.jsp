<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
<title>班级管理</title>
</head>

<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<form name="createForm" action="" method="post">
<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="20%" align="left">[班级管理]</td>
    <td width="42%"align="center">&nbsp;</td>
    <td width="36%"align="right">
    	<a href="${pageContext.request.contextPath}/classes_saveUI.action"><img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/></a>
        <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
    </td>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1">
<thead>
  <tr class="henglan" style="font-weight:bold;">
	<th width="10%" align="center">班级名称</th>
    <th width="10%" align="center">所属课程</th>
    <th width="10%" align="center">开班时间</th>
    <th width="10%" align="center">毕业时间</th>
    <th width="10%" align="center">状态</th>
    <th width="10%" align="center">学生总数</th>
    <th width="5%" align="center">编辑</th>
	<th width="5%" align="center">删除</th>
  </tr>
  </thead>
  <tbody>
  <s:iterator value="list" var="c" status="status">
  <s:if test="#status.count%2==0">
  <tr class="tabtd1">
  </s:if>
  <s:else>
  <tr class="tabtd2">
  </s:else>
    <td align="center"><s:property value="#c.cname" /></td>
    <td align="center"><s:property value="#c.courseType.tname" /></td>
    <td align="center"><s:date name="#c.beginDate" format="yyyy-MM-dd" /></td>
    <td align="center"><s:date name="#c.endDate" format="yyyy-MM-dd" /></td>
    <td align="center">
    	<s:if test="#c.state == 1">未开课</s:if> 
    	<s:if test="#c.state == 2">已开课</s:if> 
    	<s:if test="#c.state == 3">已结课</s:if> 
    </td>
    <td align="center"><s:property value="#c.num" /></td>
    <td align="center"><a href="${pageContext.request.contextPath}/classes_edit.action?cid=<s:property value="#c.cid" />"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"></a></td>
	<td align="center"><a href="${pageContext.request.contextPath}/classes_delete.action?cid=<s:property value="#c.cid" />"><img src="${pageContext.request.contextPath}/images/button/delete.gif" class="img"></a></td>
  </tr>
  </s:iterator>
  </tbody>
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第<s:property value="currentPage" />/<s:property value="totalPage" />页</span>&nbsp;&nbsp;
    	<span>总记录数：<s:property value="totalCount" /></span>&nbsp;&nbsp;
    	<span>每页显示：<s:property value="pageSize" /></span>&nbsp;&nbsp;
        <span>
        	<s:if test="currentPage!=1">
	        	<a href="${pageContext.request.contextPath}/classes_findByPage.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/classes_findByPage.action?currentPage=<s:property value="currentPage-1" />">[上一页]</a>&nbsp;&nbsp;
            </s:if>
            <s:iterator begin="1" end="totalPage" var="i">
            	<s:if test="currentPage == #i">
            		<s:property value="#i"/>
            	</s:if>
            	<s:else>
            		<a href="${pageContext.request.contextPath}/classes_findByPage.action?currentPage=<s:property value="#i" />"><s:property value="#i"/></a>
            	</s:else>
            </s:iterator>
            <s:if test="currentPage!=totalPage">
	            <a href="${pageContext.request.contextPath}/classes_findByPage.action?currentPage=<s:property value="currentPage+1" />">[下一页]</a>&nbsp;&nbsp;
	            <a href="${pageContext.request.contextPath}/classes_findByPage.action?currentPage=<s:property value="totalPage" />">[尾页]</a>
            </s:if>
        </span>
    </td>
  </tr>
</table>
</body>
</html>
