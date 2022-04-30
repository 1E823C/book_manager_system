package cn.tedu.dao;

import java.util.List;

import cn.tedu.model.Book;

public interface bookDao {
	public List<Book> list();
	
	public void addBook(Book book);
	
	public Book selectById(int bid);
	
	public void modifyBook(Book book);
	
	public void deleteBook(int bid);
	
	public List<Book> listByName(String bname);
}
