<%@page import="cn.tedu.model.Record"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>欢迎使用图书管理系统</h1>
<hr>
     <a href="javascript:void(0)">添加借书信息</a>
     <a href="javascript:void(0)">删除借书信息</a>
     <a href="javascript:void(0)">修改借书信息</a>
     <a href="javascript:void(0)">查询借书信息</a>
     <a href="index.jsp">返回目录</a>
<hr> 
<form action="delete" method="post" name="mydelete">
 <table>
    <tr>
    	<td width="50">修改</td>
    	<td width="50">删除</td>
    	<td width="100">用户名</td>
    	<td width="200">用户id</td>
    	<td width="150">书名</td>
    	<td width="50">书号</td>
    	<td width="150">借书日期</td>
    	<td width="125">电话号码</td>
    	<td width="150">地址</td>
    </tr>
	 <% 
   		List<Record> recordlist = null;
   		if(request.getSession().getAttribute("recordlist") != null){
   			recordlist = (List<Record>)request.getSession().getAttribute("recordlist");
   		}
   		
   		int pageNo=1;// 当前页码
    	int itemCount=0;//一共有多少条记录
    	int pageItem=10;//每页显示多少条
    	int pageCount =0;// 页面总数 	
    	
    	if(request.getParameter("pageNo") != null){
    		pageNo = Integer.parseInt(request.getParameter("pageNo"));
    	}
   		if(recordlist != null){
   			itemCount = recordlist.size();
   		}
   		if(itemCount % pageItem == 0){
   			pageCount = itemCount/pageItem;
   		}else{
   			pageCount = itemCount/pageItem + 1;
   		}
   		
   		for(int i=(pageNo - 1)*pageItem;i<pageNo*pageItem && i<itemCount;i++){
   			
   			Record  re = new Record();
   			re = recordlist.get(i);
   		%>
   	<tr>
   				<td><input type="radio" name="mdf" onclick="sel_radio(this)" value="<%=re.getRecordid()%>" /></td>
   				<td><input type="checkbox" name="del" id="del" value="<%=re.getRecordid()%>" /></td>
   				<td><%=re.getUname()%></td>
   				<td><%=re.getUid()%></td>
   				<td><%=re.getBname()%></td>
   				<td><%=re.getBid()%></td>
   				<td><%=re.getTime()%></td>
   				<td><%=re.getTelephone()%></td>
   				<td><%=re.getAddress()%></td>		
   	</tr>	
   	
   	<%} %>
   		
</table>
</form>
</body>
</html>