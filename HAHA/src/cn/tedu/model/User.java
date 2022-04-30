package cn.tedu.model;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String idnumber;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdnumer() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber ;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	
	
	
}
