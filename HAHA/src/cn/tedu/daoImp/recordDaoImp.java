package cn.tedu.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.tedu.dao.recordDao;
import cn.tedu.model.Record;
import cn.tedu.util.DBConnectionPool;

public class recordDaoImp implements recordDao {

	@Override
	public List<Record> listByUname(String uname){
		Connection conn = DBConnectionPool.getInstance().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Record>  re = null;
		
		try {
			if(uname.equals("admin")) {
			ps = conn.prepareStatement("select recordid,uname,uid,bname,bid,time,telephone,address from record ");
			rs = ps.executeQuery();
			if(rs != null) {
				re = new ArrayList<Record>();
				while(rs.next()) {
					Record record = new Record();
					record.setRecordid(rs.getInt("recordid"));
					record.setUname(rs.getString("uname"));
					record.setUid(rs.getString("uid"));
					record.setBname(rs.getString("bname"));
					record.setBid(rs.getInt("bid"));
					record.setTime(rs.getString("time"));
					record.setTelephone(rs.getString("telephone"));
					record.setAddress(rs.getString("address"));
					re.add(record);
				}
			}	
		}else {
			ps = conn.prepareStatement("select recordid,uname,uid,bname,bid,time,telephone,address from record where uname=? ");
			ps.setString(1, uname);
			rs = ps.executeQuery();
			if(rs != null) {
				re = new ArrayList<Record>();
				while(rs.next()) {
					Record record = new Record();
					record.setRecordid(rs.getInt("recordid"));
					record.setUname(rs.getString("uname"));
					record.setUid(rs.getString("uid"));
					record.setBname(rs.getString("bname"));
					record.setBid(rs.getInt("bid"));
					record.setTime(rs.getString("time"));
					record.setTelephone(rs.getString("telephone"));
					record.setAddress(rs.getString("address"));
					re.add(record);
				}
			}	
		}
		}catch (Exception e) {
			// TODO: handle exception	
			e.printStackTrace();
		}
		return re;
	}
//	public List<Record> list() {
//		// TODO Auto-generated method stub
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ArrayList<Record>  bo = null;
//		try {
//			ps = conn.prepareStatement("select recordid,uname,uid,bname,bid,time,telphone,address from record ");
//			rs = ps.executeQuery();
//			if(rs != null) {
//				bo = new ArrayList<Record>();
//				while(rs.next()) {
//					Record record = new Record();
//					record.setRecordid(rs.getInt("recordid"));
//					record.setUname(rs.getString("uname"));
//					record.setUid(rs.getString("uid"));
//					record.setBname(rs.getString("bname"));
//					record.setBid(rs.getInt("bid"));
//					record.setTime(rs.getString("time"));
//					record.setTelephone(rs.getString("telphone"));
//					record.setAddress(rs.getString("address"));
//					bo.add(record);
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DBConnectionPool.getInstance().releaseConn(conn);
//		return bo;		
//	}
	
//	public void addRecord(Record record) {
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement("select uname,uid from record where uid=?");
//			ps.setString(1,record.getBname());
//			rs = ps.executeQuery();
//			int num = 0;
//			while(rs.next()){	
//				if( (rs.getString("uid")).equals(record.getUid()) ) {
//					System.out.print("此人已存在！");
//					num = 1;
//					break;
//					}
//			}
//			if(num == 0) {
//				ps = conn.prepareStatement("insert into record(recordid,uname,uid,bname,bid,time,telphone,addressuname,uid,bname,bid,time,telphone,address) values(?,?,?,?,?,?,?,?)");
//				ps.setString(1,record.getBname());
//				ps.setString(2,record.getUname());
//				ps.setString(3,record.getUid());
//				ps.setString(4,record.getTelephone());
//				ps.setString(5,record.getAddress());
//				ps.executeUpdate();
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		DBConnectionPool.getInstance().releaseConn(conn);
//	}
//	
//	public Record selectById(int uid) {
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Record book = null;
//		try {
//			ps = conn.prepareStatement("select recordid,uname,uid,bname,bid,time,telphone,address from record ");
//			rs = ps.executeQuery();
//			if(rs != null) {
//				while(rs.next()) {
//					Record record = new Record();
//					record.setRecordid(rs.getInt("recordid"));
//					record.setUname(rs.getString("uname"));
//					record.setUid(rs.getString("uid"));
//					record.setBname(rs.getString("bname"));
//					record.setBid(rs.getInt("bid"));
//					record.setTime(rs.getString("time"));
//					record.setTelephone(rs.getString("telphone"));
//					record.setAddress(rs.getString("address"));
//				}
//			}
//	}catch (Exception e) {
//		// TODO: handle exception
//	}
//		DBConnectionPool.getInstance().releaseConn(conn);
//		return book;
//}
//	
//	public void modifyRecord(Record record) {
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(" update record set bname=?,uname=?,uid=?,telephone=?,address=? where uid=?");
//			ps.setString(1,record.getBname());
//			ps.setString(2,record.getUname());
//			ps.setString(3,record.getUid());
//			ps.setString(4,record.getTelephone());
//			ps.setString(5,record.getAddress());
//			ps.executeUpdate();
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		DBConnectionPool.getInstance().releaseConn(conn);
//	}
//	
//	/*public void deleteRecord(int uid) {
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement("delete from book where recordid=?");
//			ps.setInt(1, recordid);
//			ps.executeUpdate();
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		DBConnectionPool.getInstance().releaseConn(conn);
//	}*/
//	
//	public List<Record> listByName(String uid){
//		Connection conn = DBConnectionPool.getInstance().getConn();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ArrayList<Record>  bo = null;
//		try {
//			ps = conn.prepareStatement("select recordid,uname,uid,bname,bid,time,telphone,address from record ");
//			rs = ps.executeQuery();
//			if(rs != null) {
//				bo = new ArrayList<Record>();
//				while(rs.next()) {
//					Record record = new Record();
//					record.setRecordid(rs.getInt("recordid"));
//					record.setUname(rs.getString("uname"));
//					record.setUid(rs.getString("uid"));
//					record.setBname(rs.getString("bname"));
//					record.setBid(rs.getInt("bid"));
//					record.setTime(rs.getString("time"));
//					record.setTelephone(rs.getString("telphone"));
//					record.setAddress(rs.getString("address"));
//					bo.add(record);
//				}
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		DBConnectionPool.getInstance().releaseConn(conn);
//		return bo;
//	
//	}

}

