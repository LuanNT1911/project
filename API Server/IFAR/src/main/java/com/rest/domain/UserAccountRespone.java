package com.rest.domain;

import java.util.Date;

public class UserAccountRespone {
	private String username;
	private String fullname;
	private Date birth;
	private String address;
	private String city;
	private String email;
	private String phone;
	private int sexual;
	private Date createdAt;
	private Date updatedAt;
	private int roleId;
	private String roleName;

	public UserAccountRespone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountRespone(String username, String fullname, Date birth, String address, String city, String email,
			String phone, int sexual, Date createdAt, Date updatedAt, int roleId, String roleName) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.birth = birth;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.sexual = sexual;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSexual() {
		return sexual;
	}

	public void setSexual(int sexual) {
		this.sexual = sexual;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
