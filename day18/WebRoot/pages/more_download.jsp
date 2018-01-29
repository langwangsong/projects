<%@page import="java.io.File"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Queue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>下载案例</h3>
	<%
		//先定义根目录
		String rootPath = "D:\\linux";
		Queue<File> queue = new LinkedList<File>();
		File rootFile = new File(rootPath);
		queue.offer(rootFile);
		while(!queue.isEmpty()){
			File file = queue.poll();
			File [] files = file.listFiles();
			for(File f:files){
				//如果是文件，显示到jsp，否则，入队
				if(f.isFile()){
	%>
					<h4><a href="${ pageContext.request.contextPath }/moredownload?filePath=<%=f.getAbsolutePath() %>"><%=f.getName() %></a></h4>
	<%
				}else{
					queue.offer(f);
				}
			}
		}
	%>
</body>
</html>