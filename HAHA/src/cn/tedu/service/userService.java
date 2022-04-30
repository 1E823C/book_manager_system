package cn.tedu.service;

import cn.tedu.model.User;

public interface userService {
	
	public boolean registerUser(User user);
	
	public User loginUser(String uname,String password);
}
