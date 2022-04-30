package cn.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class DBConnectionPool {
	
		private static DBConnectionPool instance = null;
		Vector<Connection> pool = new Vector<Connection>();
		
		private static String driver = ConfigManager.getProperty("driver");// 数据库驱动字符串
	    private static String url = ConfigManager.getProperty("url");// 连接URL字符串
	    private static String user = ConfigManager.getProperty("user"); // 数据库用户名
	    private static String password = ConfigManager.getProperty("password"); // 用户密码
		
		public static DBConnectionPool getInstance() {
			if(instance == null) {
				instance = new DBConnectionPool();
			}
			return instance;
		}
		
		/*加载数据库驱动*/
		static {
			try {
				Class.forName(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
			
		/*获取数据库连接*/
		public DBConnectionPool() {		
				try {
					for(int i=0;i<10;i++) {
					Connection conn = DriverManager.getConnection(url,user,password);
					pool.add(conn);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		/*获得数据库连接对象*/
		public Connection getConn() {
			Connection conn = null;
			if(pool.size() > 0) {
				conn = pool.get(0);
				pool.remove(conn);
			}
			return conn;
		}
		
		/*释放数据库连接 */
		public void releaseConn(Connection conn) {
			if(conn != null) {
				pool.add(conn);
			}
		}
		
		
				
		
}


