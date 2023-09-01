package com.dnapass.training.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user200")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String mobileNumber;
	private String state;
	private String city;
	private String pincode;
	private String role;
	private String username;
	private String password;
	
	public User(String mobileNumber, String state, String city, String pincode, String role, String username,
			String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	public User(String mobileNumber, String state, String city, String pincode, String role, String username) {
		super();
		this.mobileNumber = mobileNumber;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.role = role;
		this.username = username;
	}
	
	
}
