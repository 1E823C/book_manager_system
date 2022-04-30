package cn.tedu.serviceImp;

import cn.tedu.dao.userDao;
import cn.tedu.daoImp.userDaoImp;
import cn.tedu.model.User;
import cn.tedu.service.userService;

public class userServiceImp implements userService {

	userDao dao = new userDaoImp();
		// TODO Auto-generated constructor stub

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public User loginUser(String uname, String password) {
		// TODO Auto-generated method stub
		return dao.loginUser(uname, password);
	}
	
	

}
