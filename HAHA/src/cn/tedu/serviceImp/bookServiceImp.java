package cn.tedu.serviceImp;

import java.util.List;

import cn.tedu.dao.bookDao;
import cn.tedu.daoImp.bookDaoImp;
import cn.tedu.model.Book;
import cn.tedu.service.bookService;

public class bookServiceImp implements bookService {
	
	bookDao dao = new bookDaoImp();
	
	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	@Override
	public void addBook(Book book) {
		dao.addBook(book);
	}
	
	public Book selectById(int bid) {
		return dao.selectById(bid);
	}
	
	public void modifyBook(Book book) {
		dao.modifyBook(book);
	}
	
	public void deleteBook(int bid) {
		dao.deleteBook(bid);
	}
	
	public List<Book> listByName(String bname){
		return dao.listByName(bname);
	}
}
