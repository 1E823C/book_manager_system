package cn.tedu.service;

import java.util.List;

import cn.tedu.model.Record;

public interface recordService {
	
	public List<Record> listByUname(String uname);
	
}
