package cn.tedu.dao;

import cn.tedu.model.User;

public interface userDao {
	public boolean registerUser(User user);
	
	public User loginUser(String uname,String password);
}
