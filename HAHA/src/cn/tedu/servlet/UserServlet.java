package cn.tedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.model.User;
import cn.tedu.service.userService;
import cn.tedu.serviceImp.userServiceImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String op = request.getParameter("op");
		
		if(op.equals("register")) {
			String idnumber = request.getParameter("uidnumber");
			String name = request.getParameter("uname");
			String password = request.getParameter("upwd");
			User user = new User();
			user.setIdnumber(idnumber);
			user.setUname(name);
			user.setPassword(password);
			userService us = new userServiceImp();
			if(us.registerUser(user)) {
				request.getSession().setAttribute("message", "注册成功，回到登录界面!");
				response.sendRedirect("loginForm.jsp");
			}else {
				request.getSession().setAttribute("message", "注册失败，请重新注册!");
				response.sendRedirect("registerForm.jsp");
			}
		}else if(op.equals("login")) {
			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			userService us = new userServiceImp();
			User user = us.loginUser(uname, password);
			if(user != null) {
				request.getSession().setAttribute("login", user);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("loginForm.jsp");
			}
		}else {
			System.out.println("无效指令");
		}
		
		
		
		
		
	}

}
