package com.sse.ch08.p1;

public class User {
	public int id;//���
	String username;//�û���
	private String password;//����
	protected int authority;//Ȩ��
	public User(){
		System.out.println("����User�Ĺ��췽��");
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
    	//�ڱ�����public,Ĭ�ϣ�private,protected���ɷ���
    	return this.id+","+this.username+","+
    			this.password+","+this.authority;
    			
    }

}
