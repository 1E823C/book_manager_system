<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#uname,#upwd{width:160px}
</style>
</head>
<body>
<%
  	if(session.getAttribute("message")!=null){
  		String msg = session.getAttribute("message")+"";
  		session.removeAttribute("message");
  		%>
  		<script type="text/javascript">alert("<%=msg%>")</script>
  		<%
  	}
  %>



<h1>欢迎使用图书管理系统</h1>
<hr>
<center>
	<form action="user?op=login" method="post">
	<table>
		<tr>
			<td align="center">登录账号:</td>
			<td align="center"><input type="text" name="uname" id="uname"></td>
		</tr>
		<tr>
			<td align="center">登录密码:</td>
			<td align="center"><input type="password" name="password" id="upwd"></td>
		</tr>
		<tr>
    		<td colspan="2" align="center">
    		<input type="submit" value=" 登录 "/>
    		<input type="reset" value=" 重置 "/>
    		<a href ="registerForm.jsp">注册</a>
     		</td>
    	</tr>	
	</table>
	</form>
</center>
</body>
</html>