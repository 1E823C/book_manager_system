package cn.tedu.dao;

import java.util.List;

import cn.tedu.model.Record;

public interface recordDao {
		
	public List<Record> listByUname(String uname);
	
}
