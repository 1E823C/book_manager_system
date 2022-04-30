<%@page import="java.util.List"%>
<%@page import="cn.tedu.model.User"%>
<%@page import="cn.tedu.model.Book"%>
<%@page import="cn.tedu.serviceImp.userServiceImp"%>
<%@page import="cn.tedu.service.userService"%>
<%@page import="cn.tedu.servlet.UserServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkSelect(){
	var bname = document.getElementById("bname");
	if(bname.value == ""){
		alert("书名不能为空!");
		bname.focus();
		return false;
	}	
}



</script>





</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    	if(session.getAttribute("login")!=null){
    		User user = (User)request.getSession().getAttribute("login");
    		if(user.getUname().equals("admin")){
    		
    %>
<h1>欢迎使用图书管理系统</h1>
<hr>
     <a href="book_add.jsp">增加新图书</a>
     <a href="javascript:void(0)">修改选中图书</a>
     <a href= "javascript:void(0)">删除选中图书</a>
     <a href="javascript:void(0)">查找图书</a>
     <a href="index.jsp">返回目录</a>
<hr>
<%
    		}else{
    			%>
<h1>欢迎使用图书管理系统</h1>
<hr>
     <a href="book_select.jsp">查找图书</a>
     <a href="index.jsp">返回目录</a>
<hr> 
<% 			
    	}
%>

    <form action="book?opr=selectBooksByName" method="post" onsubmit="return checkSelect()">
   	 按书名查找：
    <input type="text" name="bname" id="bname"/> &nbsp;
    <input type="submit" value="查询">
    </form>

<% 
   }
%>




</body>
</html>