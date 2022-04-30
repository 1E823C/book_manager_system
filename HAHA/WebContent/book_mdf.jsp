<%@page import="cn.tedu.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#bname,#author,#country,#publisher,#type,#price,#location,#total{width:160px}
</style>
<script type="text/javascript">
function checkAdd(){
	var bname = document.getElementById("bname");
	var author = document.getElementById("author");
	var country = document.getElementById("country");
	var publisher = document.getElementById("publisher");
	var type = document.getElementById("type");
	var price = document.getElementById("price");
	var location = document.getElementById("location");

	if(bname.value == ""){
		alert("书名不能为空!");
		bname.focus();
		return false;
	}
	if(author.value == ""){
		alert("作者不能为空!");
		author.focus();
		return false;
	}
	if(country.value == ""){
		alert("国家不能为空!");
		country.focus();
		return false;
	}
	if(publisher.value == ""){
		alert("出版社不能为空!");
		publisher.focus();
		return false;
	}
	if(type.value == ""){
		alert("类型不能为空!");
		type.focus();
		return false;
	}
	if(price.value == ""){
		alert("价格不能为空!");
		price.focus();
		return false;
	}
	if (isNaN(price.value)) {
		alert("价格含有非数字!");
		price.focus();
		return false;
	} 
	if(location.value == ""){
		alert("位置不能为空!");
		location.focus();
		return false;
	}
}
</script>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	if(session.getAttribute("book") != null){
  		Book bo = (Book)request.getSession().getAttribute("book");
%>
<h1>欢迎使用图书管理系统</h1>
<hr>
     <a href="book_add.jsp">增加新图书</a>
     <a href="book_mdf.jsp">修改选中图书</a>
     <a href="delete">删除选中图书</a>
     <a href="book_select.jsp">查找图书</a>
     <a href="index.jsp">返回目录</a>
<hr>
<center>
 	<form  action="book?opr=mdfBooks" method="post" onsubmit="return checkAdd()" >
 		<input type="hidden" name="bid" value="<%=bo.getBid()%>">
 	<table>
 		<tr>
 			<td align="right">书名：</td>
 			<td align="left"><input type="text" name="bname" id="bname" value="<%=bo.getBname()%>"/></td>
 		</tr>
 		<tr>
 			<td align="right">作者：</td>
 			<td align="left"><input type="text" name="author" id="author" value="<%=bo.getAuthor()%>"/></td>
 		</tr>
 			<td align="right">国家：</td>
 			<td align="left"><input type="text" name="country" id="country" value="<%=bo.getCountry()%>"/></td>
 		<tr>
 			<td align="right">出版社：</td>
 			<td align="left"><input type="text" name="publisher" id="publisher" value="<%=bo.getPublisher()%>"/></td>
 		</tr>
 		<tr>
 			<td align="right">类型：</td>
 			<td align="left"><input type="text" name="type" id="type" value="<%=bo.getType()%>"/></td>
 		</tr>
 		<tr>
 			<td align="right">价格：</td>
 			<td align="left"><input type="text" name="price" id="price" value="<%=bo.getPrice()%>"/></td>
 		</tr>
 		<tr>
 			<td align="right">位置：</td>
 			<td align="left"><input type="text" name="location" id="location" value="<%=bo.getLocation()%>"/></td>
 		</tr>
 		<tr>
 			<td align="right">数量：</td>
 			<td align="left"><input type="text" name="total" id="total" value="<%=bo.getTotal()%>"/></td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center">
    		<input type="submit" value=" 修改 "/>
    		<input type="reset" value=" 重置 "/>
     		</td>
 		</tr>
 	</table>
 	</form>
 </center>	
 <%} %>
</body>
</html>