package cn.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.model.Book;
import cn.tedu.model.User;
import cn.tedu.service.bookService;
import cn.tedu.serviceImp.bookServiceImp;
import cn.tedu.util.DBConnectionPool;



/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User  user = (User)request.getSession().getAttribute("login");
        String opr = request.getParameter("opr");
        String opr2 = (String)request.getAttribute("opr2");
        if(opr2 != null) {
        	opr = opr2;
        }
        try {
            if (opr.equals("showBooks")) {
            	bookService bo = new bookServiceImp();
                List<Book> book = bo.list();
                request.getSession().setAttribute("booklist", book);
                response.sendRedirect("bookInfo.jsp");
            }else if(opr.equals("addBooks")) {
            	bookService bo = new bookServiceImp(); 
            	Book book = new Book();
            	book.setBname(request.getParameter("bname"));
            	book.setAuthor(request.getParameter("author"));
            	book.setCountry(request.getParameter("country"));
            	book.setPublisher(request.getParameter("publisher"));
            	book.setType(request.getParameter("type"));
            	book.setPrice(Integer.parseInt(request.getParameter("price")));
            	book.setLocation(request.getParameter("location"));
            	bo.addBook(book);
                List<Book> book1 = bo.list();
                request.getSession().setAttribute("booklist", book1);
        		response.sendRedirect("bookInfo.jsp");
            }else if(isNumber(opr)){
            	bookService  bo = new bookServiceImp();
        		Book book = bo.selectById(Integer.parseInt(opr));
        		request.getSession().setAttribute("book", book);
        		response.sendRedirect("book_mdf.jsp");
            }else if(opr.equals("mdfBooks")){
            	bookService bo = new bookServiceImp();
            	Book book = new Book();
            	book.setBid(Integer.parseInt(request.getParameter("bid")));    
            	book.setBname(request.getParameter("bname"));
            	book.setAuthor(request.getParameter("author"));
            	book.setCountry(request.getParameter("country"));
            	book.setPublisher(request.getParameter("publisher"));
            	book.setType(request.getParameter("type"));
            	book.setPrice(Integer.parseInt(request.getParameter("price")));
            	book.setLocation(request.getParameter("location"));
            	book.setTotal(Integer.parseInt(request.getParameter("total")));          	
            	bo.modifyBook(book);
            	List<Book> book2 = bo.list();
                request.getSession().setAttribute("booklist", book2);
         		response.sendRedirect("bookInfo.jsp");	
            }
//            else if(opr.equals("deleteBooks")) {
//            	String  ids = request.getParameter("array");            	
//            	bookService bo = new bookServiceImp();
//        		for(String i: ids){
//
//        			int  bid = Integer.parseInt(i);
//        			bo.deleteBook(bid);
//        		}
//        		List<Book> book3 = bo.list();
//                request.getSession().setAttribute("booklist", book3);
//         		response.sendRedirect("bookInfo.jsp");	
//            }
            else if(opr.equals("selectBooksByName")) {
            	String bname = request.getParameter("bname");
            	bookService bo = new bookServiceImp();
                List<Book> book4 = bo.listByName(bname);
                if(book4 == null) {
                }
                request.getSession().setAttribute("booklist", book4);
        		response.sendRedirect("bookInfo.jsp");
            }else {
            	System.out.println("无效指令");
            }
            }catch (Exception e) {
				// TODO: handle exception
			}

	}
	
		public static boolean isNumber(String str){
			for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
			return false;
			}
			}
			return true;
			}
}
