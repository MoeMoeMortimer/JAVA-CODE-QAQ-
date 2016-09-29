package com.sse.ch08.p1;

public class User {
	public int id;//编号
	String username;//用户名
	private String password;//密码
	protected int authority;//权限
	public User(){
		System.out.println("父类User的构造方法");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
    public String toString(){
    	//在本类中public,默认，private,protected均可访问
    	return this.id+","+this.username+","+
    			this.password+","+this.authority;
    			
    }

}
