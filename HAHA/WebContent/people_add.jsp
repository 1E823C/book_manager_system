<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#bname,#uname,#uid,#telphone,#address{width:160px}
</style>
<script type="text/javascript">
function checkAdd(){
	var uname = document.getElementById("uname");
	var bname = document.getElementById("bname");
	var uid = document.getElementById("uid");
	var telphone = document.getElementById("telphone");
	var address = document.getElementById("address");

	if(bname.value == ""){
		alert("书名不能为空!");
		bname.focus();
		return false;
	}
	if(uname.value == ""){
		alert("借阅人不能为空!");
		author.focus();
		return false;
	}
	if(uid.value == ""){
		alert("身份证号不能为空!");
		country.focus();
		return false;
	}
	if(telphone.value == ""){
		alert("电话号不能为空!");
		publisher.focus();
		return false;
	}
	if(address.value == ""){
		alert("地址不能为空!");
		type.focus();
		return false;
	}
	
}
</script>
</head>
<body>
<h1>欢迎使用图书管理系统</h1>
<hr>
     <a href="people_add.jsp">增加借阅人</a>
     <a href="people_mdf.jsp">修改借阅人信息</a>
     <a href="people_delete">删除借阅人信息</a>
     <a href="people_select.jsp">查找借阅人</a>
     <a href="index.jsp">返回目录</a>
<hr>
<center>
 	<form  action="book?opr=addBooks" method="post" onsubmit="return checkAdd()" >
 	<table>
 		<tr>
 			<td align="right">书名：</td>
 			<td align="left"><input type="text" name="bname" id="bname"></td>
 		</tr>
 		<tr>
 			<td align="right">借阅人：</td>
 			<td align="left"><input type="text" name="uname" id="uname"></td>
 		</tr>
 			<td align="right">身份证号：</td>
 			<td align="left"><input type="text" name="uid" id="uid"></td>
 		<tr>
 			<td align="right">电话号：</td>
 			<td align="left"><input type="text" name="telphone" id="telphone"></td>
 		</tr>
 		<tr>
 			<td align="right">家庭住址：</td>
 			<td align="left"><input type="text" name="address" id="address"></td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center">
    		<input type="submit" value=" 添加 "/>
    		<input type="reset" value=" 重置 "/>
     		</td>
 		</tr>
 	</table>
 	</form>
 </center>	
</body>
</html>