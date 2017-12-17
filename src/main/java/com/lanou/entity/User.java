package com.lanou.entity;

import java.util.List;

public class User {

	private int uId;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String realname;
	
	private String sex;
	
	private String birthday;
	
	private String telephone;
	
	private String phone;
	
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uId, String username, String password, String email) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", realname=" + realname + ", sex=" + sex + ", birthday=" + birthday + ", telephone=" + telephone
				+ ", phone=" + phone + ", addresses=" + addresses + "]";
	}


}
