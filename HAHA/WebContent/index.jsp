<%@page import="cn.tedu.model.User"%>
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
function check() {
	var uname = document.getElementsByName("uname");
	// 已经选中了，将选中的数据 提交到servlet中处理
	document.show.submit();
}



</script>


</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    	if(session.getAttribute("login")!=null){
    		User user = (User)request.getSession().getAttribute("login");
    		String uname = user.getUname();
    	
    %>
    
<h1>欢迎使用图书管理系统</h1>
<hr>
<form  action="record" method="post"  name="show"  >
 		<input type="hidden" name="uname" value="<%=uname%>">
</form>
 		
 		
<p><a href = "book?opr=showBooks">图书信息</a>
<p><a href="javascript:void(0)" onclick="check()">借阅信息</a>
<p><a href = "loginForm.jsp">注销</a>

<%} %>
</body>
</html>