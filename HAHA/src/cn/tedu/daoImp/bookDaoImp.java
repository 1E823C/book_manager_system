package cn.tedu.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.dao.bookDao;
import cn.tedu.model.Book;
import cn.tedu.util.DBConnectionPool;
import jdk.nashorn.internal.ir.SetSplitState;

public class bookDaoImp implements bookDao {

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book>  bo = null;
		try {
			ps = conn.prepareStatement("select bid,bname,author,country,publisher,type,price,location,total from book ");
			rs = ps.executeQuery();
			if(rs != null) {
				bo = new ArrayList<Book>();
				while(rs.next()) {
					Book book = new Book();
					book.setBid(rs.getInt("bid"));
					book.setBname(rs.getString("bname"));
					book.setAuthor(rs.getString("author"));
					book.setCountry(rs.getString("country"));
					book.setPublisher(rs.getString("publisher"));
					book.setType(rs.getString("type"));
					book.setPrice(rs.getInt("price"));
					book.setLocation(rs.getString("location"));
					book.setTotal(rs.getInt("total"));
					bo.add(book);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnectionPool.getInstance().releaseConn(conn);
		return bo;		
	}
	
	public void addBook(Book book) {
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select bid,bname,publisher,total from book where bname=?");
			ps.setString(1,book.getBname());
			rs = ps.executeQuery();
			int num = 0;
			while(rs.next()){	
				if( (rs.getString("publisher")).equals(book.getPublisher()) ) {
					num++;
					int number = rs.getInt("total")+1;
					ps = conn.prepareStatement("update book set total=? where bid=?");
					ps.setInt(1,number);
					ps.setInt(2,rs.getInt("bid"));
					ps.executeUpdate();
					break;
					}
			}
			if(num == 0) {
				ps = conn.prepareStatement("insert into book(bname,author,country,publisher,type,price,location,total) values(?,?,?,?,?,?,?,?)");
				ps.setString(1,book.getBname());
				ps.setString(2,book.getAuthor());
				ps.setString(3,book.getCountry());
				ps.setString(4,book.getPublisher());
				ps.setString(5,book.getType());
				ps.setInt(6,book.getPrice());
				ps.setString(7,book.getLocation());
				ps.setInt(8,1);
				ps.executeUpdate();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnectionPool.getInstance().releaseConn(conn);
	}
	
	public Book selectById(int bid) {
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			ps = conn.prepareStatement("select bid,bname,author,country,publisher,type,price,location,total from book where bid=? ");
			ps.setInt(1,bid);
			rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setCountry(rs.getString("country"));
				book.setPublisher(rs.getString("publisher"));
				book.setType(rs.getString("type"));
				book.setPrice(rs.getInt("price"));
				book.setLocation(rs.getString("location"));
				book.setTotal(rs.getInt("total"));
			}
	}catch (Exception e) {
		// TODO: handle exception
	}
		DBConnectionPool.getInstance().releaseConn(conn);
		return book;
}
	
	public void modifyBook(Book book) {
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(" update book set bname=?,author=?,country=?,publisher=?,type=?,price=?,location=?,total=? where bid=?");
			ps.setString(1, book.getBname());
			ps.setString(2, book.getAuthor() );
			ps.setString(3, book.getCountry());
			ps.setString(4, book.getPublisher());
			ps.setString(5, book.getType());
			ps.setInt(6, book.getPrice());
			ps.setString(7,book.getLocation());
			ps.setInt(8, book.getTotal());
			ps.setInt(9, book.getBid());
			ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		DBConnectionPool.getInstance().releaseConn(conn);
	}
	
	public void deleteBook(int bid) {
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("delete from book where bid=?");
			ps.setInt(1, bid);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		DBConnectionPool.getInstance().releaseConn(conn);
	}
	
	public List<Book> listByName(String bname){
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book>  bo = null;
		try {
			ps = conn.prepareStatement("select bid,bname,author,country,publisher,type,price,location,total from book where bname like '%"+bname+"%' order by bid ASC");
			rs = ps.executeQuery();
			if(rs!=null){
				bo = new ArrayList<Book>();
				while(rs.next()){
					Book book = new Book();
					book.setBid(rs.getInt("bid"));
					book.setBname(rs.getString("bname"));
					book.setAuthor(rs.getString("author"));
					book.setCountry(rs.getString("country"));
					book.setPublisher(rs.getString("publisher"));
					book.setType(rs.getString("type"));
					book.setPrice(rs.getInt("price"));
					book.setLocation(rs.getString("location"));
					book.setTotal(rs.getInt("total"));
					bo.add(book);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnectionPool.getInstance().releaseConn(conn);
		return bo;
	
	}
}

