package cn.tedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Connection conn  = DBConnectionPool.getInstance().getConn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from user";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			DBConnectionPool.getInstance().releaseConn(conn);
			while(rs.next()) {
				String userid = rs.getString("uid");
				String uname = rs.getString("uname");
				String upwd = rs.getString("password");
				System.out.println(userid+uname+upwd);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
