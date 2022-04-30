<%@page import="java.util.List"%>
<%@page import="cn.tedu.model.User"%>
<%@page import="cn.tedu.model.Book"%>
<%@page import="cn.tedu.serviceImp.userServiceImp"%>
<%@page import="cn.tedu.service.userService"%>
<%@page import="cn.tedu.servlet.UserServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#uname,#upwd{width:160px}
</style>
<script type="text/javascript">
function sel_radio(radio) {
	var mdf_link = document.getElementById("mdf_link");
	var id =radio.value;
	mdf_link.href ="book?opr="+id;// 将链接提交到serv
}

function check_del() {
	var dels = document.getElementsByName("del");
	var flag = false;
	for(i=0;i<dels.length;i++){
		if(dels[i].checked==true){
			flag = true;
		}
	}
	if(flag==true){// 已经选中了，将选中的数据 提交到servlet中处理
		document.mydelete.submit();
		
	}else{
		alert("至少选中一条记录删除");
	}
}

function array() {
	var dels = document.getElementsByName("del");
	return dels;
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
     <a href="javascript:void(0)" id="mdf_link">修改选中图书</a>
     <a href="javascript:void(0)" onclick="check_del()">删除选中图书</a>
     <a href="book_select.jsp">查找图书</a>
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
<form action="delete" method="post" name="mydelete">
 <table>
    <tr>
    	<td width="50">修改</td>
    	<td width="50">删除</td>
    	<td width="50">书号</td>
    	<td width="150">书名</td>
    	<td width="150">作者</td>
    	<td width="100">国家</td>
    	<td width="200">出版社</td>
    	<td width="75">类型</td>
    	<td width="50">价格</td>
    	<td width="150">位置</td>
    	<td width="50">数量</td>
    </tr>
   <% 
   		List<Book> booklist = null;
   		if(request.getSession().getAttribute("booklist") != null){
   			booklist = (List<Book>)request.getSession().getAttribute("booklist");
   		}
   		
   		int pageNo=1;// 当前页码
    	int itemCount=0;//一共有多少条记录
    	int pageItem=15;//每页显示多少条
    	int pageCount =0;// 页面总数 	
    	
    	if(request.getParameter("pageNo") != null){
    		pageNo = Integer.parseInt(request.getParameter("pageNo"));
    	}
   		if(booklist != null){
   			itemCount = booklist.size();
   		}
   		if(itemCount % pageItem == 0){
   			pageCount = itemCount/pageItem;
   		}else{
   			pageCount = itemCount/pageItem + 1;
   		}
   		
   		for(int i=(pageNo - 1)*pageItem;i<pageNo*pageItem && i<itemCount;i++){
   			
   			Book bo = new Book();
   			bo = booklist.get(i);
   %>
   			<tr>
   				<td><input type="radio" name="mdf" onclick="sel_radio(this)" value="<%=bo.getBid()%>"></td>
   				<td><input type="checkbox" name="del" id="del" value="<%=bo.getBid()%>"></td>
   				<td><%=bo.getBid()%></td>
   				<td><%=bo.getBname()%></td>
   				<td><%=bo.getAuthor()%></td>
   				<td><%=bo.getCountry()%></td>
   				<td><%=bo.getPublisher()%></td>
   				<td><%=bo.getType()%></td>
   				<td><%=bo.getPrice()%></td>
   				<td><%=bo.getLocation()%></td>
   				<td><%=bo.getTotal()%></td>
   			</tr>		
   <% 
   			}
   %>
</table>
</form>
<%
	if(pageNo>1){
		%>
		<a href ="bookInfo.jsp?pageNo=<%=pageNo-1%>">[上一页]</a>
		<% 
	}
	for(int i=1;i<=pageCount;i++){
		if(pageNo==i){
			%>
			[<%=i %>]
			<% 
		}else{
			%>
			<a href="bookInfo.jsp?pageNo=<%=i%>">[<%=i%>]</a>
			<% 
		}
	}
	if(pageNo<pageCount){
		%>
		<a href = "bookInfo.jsp?pageNo=<%=pageNo+1%>">[下一页]</a>
		<% 
	}
    		}
%>

</body>
</html>