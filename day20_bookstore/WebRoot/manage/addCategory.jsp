<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/manage/header.jsp" %>
	<h3>添加分类</h3>
	<form action="${ pageContext.request.contextPath }/manage/ManageServlet?op=addCategory" method="post">
		<table border="1" width="438">
			<tr>
				<td><span class="required">*</span>分类名称：</td>
				<td>
					<input type="text" id="name" name="name" />
					<span id="s1" style="color:red;display:none">分类名称不可用</span>
					<span id="s2" style="color:green;display:none">分类名称可以使用</span>
				</td>
				
			</tr>
			<tr>
				<td>分类描述：</td>
				<td><textarea rows="3" cols="38" name="description"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		//异步交互：检查分类名称是否相同
		window.onload = function(){//匿名函数,页面加载完毕后立即执行
			//给name注册时间
			document.getElementById("name").onblur = function(){
				//获取用户的输入值
				var name = this.value;
				//判断是否输了值
				if("" == name.trim()){
					alert("请输入分类名称");
					this.focus();//重新得到焦点
					return;
				}
				//用户输入了名称：把名称异步发给服务器验证
				var xhr = getXhr();
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4 ){//服务器响应完毕
						if(xhr.status == 200){
							var result = xhr.responseText;//true|false 字符串类型
							if(result=="true"){
								document.getElementById("s1").style.display = "block";
								document.getElementById("s2").style.display = "none";
							}else{
								document.getElementById("s2").style.display = "block";
								document.getElementById("s1").style.display = "none";
							}
						}
					}
				}
				xhr.open("POST", "${ pageContext.request.contextPath }/manage/ManageServlet?op=checkCategoryName&time="+new Date().getTime());//建立与服务器的连接
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//设置请求消息头，告知服务器正文内容的类型
				xhr.send("name="+name);	//向服务传送数据
		}
		}
	</script>
  </body>
</html>
