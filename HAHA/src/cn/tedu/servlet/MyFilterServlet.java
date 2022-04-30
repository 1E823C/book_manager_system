package cn.tedu.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyFilterServlet implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest  request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)resp;
			HttpSession  session = request.getSession();
			if(session.getAttribute("login")!= null){
				chain.doFilter(req, resp);
			}else if(
					(request.getContextPath()+"/index.jsp").equals(request.getRequestURI())  ||
					(request.getContextPath()+"/loginForm.jsp").equals(request.getRequestURI()) ||
					(request.getContextPath()+"/registerForm.jsp").equals(request.getRequestURI()) ||
					(request.getContextPath()+"/user").equals(request.getRequestURI()) ||
					(request.getContextPath()+"/error.jsp").equals(request.getRequestURI())
					){
				chain.doFilter(req, resp);
			}else{
				response.sendRedirect("error.jsp");
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
