package cn.tedu.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.tedu.dao.userDao;
import cn.tedu.model.User;
import cn.tedu.util.DBConnectionPool;

public class userDaoImp implements userDao {

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select idnumber,uname from user where idnumber=? or uname=?");
			ps.setString(1, user.getIdnumer());
			ps.setString(2, user.getUname());
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = false;
			}else {
				ps = conn.prepareStatement("insert into user(uname,password,idnumber) values(?,?,?)");
				ps.setString(1,user.getUname());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getIdnumer());
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnectionPool.getInstance().releaseConn(conn);
		return flag;
	}

	@Override
	public User loginUser(String uname, String password) {
		// TODO Auto-generated method stub
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try{
			ps = conn.prepareStatement("select uid,uname,password from user where uname=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		DBConnectionPool.getInstance().releaseConn(conn);
		return user;
	}

}
