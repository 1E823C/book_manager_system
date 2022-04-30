package cn.tedu.serviceImp;

import cn.tedu.service.recordService;
import java.util.List;

import cn.tedu.dao.bookDao;
import cn.tedu.dao.recordDao;
import cn.tedu.daoImp.bookDaoImp;
import cn.tedu.daoImp.recordDaoImp;
import cn.tedu.model.Book;
import cn.tedu.model.Record;
import cn.tedu.service.recordService;

public class recordServiceImp implements recordService{
	recordDao dao = new recordDaoImp();
	
	public List<Record> listByUname(String uname){
		return dao.listByUname(uname);
	}
}
