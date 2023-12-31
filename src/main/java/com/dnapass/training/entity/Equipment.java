package com.dnapass.training.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="equipment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer count;
	private Double rentPerDay;
	private String state;
	private String city;
	private String village;
	private String pincode;
	private String contactPerson;
	private String mobileNumber;
	private String status;
	
	@OneToOne
	@JoinColumn(name="userId")
	@JsonBackReference
	private User user;

	public Equipment(String name, Integer count, Double rentPerDay, String state, String city, String village,
			String pincode, String contactPerson, String mobileNumber, String status, User user) {
		super();
		this.name = name;
		this.count = count;
		this.rentPerDay = rentPerDay;
		this.state = state;
		this.city = city;
		this.village = village;
		this.pincode = pincode;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.user = user;
	}

	public Equipment(String name, Integer count, Double rentPerDay, String state, String city, String village,
			String pincode, String contactPerson, String mobileNumber, User user) {
		super();
		this.name = name;
		this.count = count;
		this.rentPerDay = rentPerDay;
		this.state = state;
		this.city = city;
		this.village = village;
		this.pincode = pincode;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.user = user;
	}

	public Equipment(Integer id, String name, Integer count, Double rentPerDay, String state, String city,
			String village, String pincode, String contactPerson, String mobileNumber, User user) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.rentPerDay = rentPerDay;
		this.state = state;
		this.city = city;
		this.village = village;
		this.pincode = pincode;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.user = user;
	}

	

	
}