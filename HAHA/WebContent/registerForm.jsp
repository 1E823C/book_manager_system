<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#uidnumber,#uname,#upwd,#upwd2{width:160px}
</style>
<script type="text/javascript">
function checkRegister() {
	var idnumber = document.getElementById("uidnumber");
	var name = document.getElementById("uname");
	var upwd = document.getElementById("upwd");
	var upwd2 = document.getElementById("upwd2");
	if(idnumber.value=="" || idnumber.value.length != 18){
		alert("身份证号不为空或不是18位");
		idnumber.focus();
		return false;
	}
	if(name.value=="" || name.value.length<2){
		alert("账号不能为空或长度小于2");
		name.focus();
		return false;
	}
	if(upwd.value=="" || upwd.value.length<6){
		alert("密码不能为空或长度小于6");
		upwd.focus();
		return false;
	}
	if(upwd2.value=="" || upwd2.value.length<6){
		alert("确认密码不能为空或长度小于6");
		upwd2.focus();
		return false;
	}
	if(upwd.value!=upwd2.value){
		alert("两次密码不一致");
		upwd2.focus();
		return false;
	}
	}
</script>


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
	<form  action="user?op=register" method="post" onsubmit="return checkRegister()">
	<table>
		<tr>
			<td align="center">身份证号:</td>
			<td align="center"><input type="text" name="uidnumber" id="uidnumber"></td>
		</tr>
		<tr>
			<td align="center">注册账号:</td>
			<td align="center"><input type="text" name="uname" id="uname"></td>
		</tr>
		<tr>
			<td align="center">注册密码:</td>
			<td align="center"><input type="password" name="upwd" id="upwd"></td>
		</tr>
		<tr>
			<td align="center">确认密码:</td>
			<td align="center"><input type="password" name="upwd2" id="upwd2"></td>
		</tr>
		<tr>
    		<td colspan="2" align="center">
    		<input type="submit" value=" 注册 "/>
    		<input type="reset" value=" 重置 "/>
     		</td>
    	</tr>	
	</table>
	</form>
</center>
</body>
</html>