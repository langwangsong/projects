<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
第${ page.currentPageNum }页/共${ page.totalPageSize }页
<a href="${pageContext.request.contextPath }${ page.url }&num=1">首页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }${ page.url }&num=${page.prePageNum}">上一页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }${ page.url }&num=${page.nextPageNum}">下一页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }${ page.url }&num=${page.totalPageSize}">尾页</a>&nbsp;&nbsp;
