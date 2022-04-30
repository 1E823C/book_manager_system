<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkSelect(){
	var uid = document.getElementById("uid");
	if(uid.value == ""){
		alert("不能为空!");
		bname.focus();
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


    <form action="book?opr=selectBooksByName" method="post" onsubmit="return checkSelect()">
   	 按身份证号查找：
    <input type="text" name="uname" id="uname"/> &nbsp;
    <input type="submit" value="查询">
    </form>






</body>
</html>