package com.micro.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 4534399449429083061L;
	
	int id;
	
	String fname;

	String lname;

	String email;

	String password;

	String role;

	Date createdDate;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int id, String fname, String lname, String email, String password, String role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserDTO(int id, String fname, String lname, String email, String password, String role, Date createdDate) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
