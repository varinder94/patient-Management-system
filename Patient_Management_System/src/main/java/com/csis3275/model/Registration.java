package com.csis3275.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	private String firstname;
	private String lastname;
	private String sex;
	private Date birthDay;
	public String email;
	private String password;
	private String telephone;
	
	//Getter and Setter
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
}
