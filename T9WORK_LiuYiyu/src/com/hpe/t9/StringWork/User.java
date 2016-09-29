package com.hpe.t9.StringWork;

public class User {
	//用户名，密码，昵称，中文名字，手机号，邮箱
	private String username;
	private String password;
	private String nickname;
	private String chname;
	private String tel;
	private String email;
	public User(String username, String password, String nickname, String chname, String tel, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.chname = chname;
		this.tel = tel;
		this.email = email;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getChname() {
		return chname;
	}
	public void setChname(String chname) {
		this.chname = chname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", nickname=" + nickname + ", chname=" + chname
				+ ", tel=" + tel + ", email=" + email + "]";
	}
}
