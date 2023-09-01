package com.dnapass.training.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipmentDetails")
public class EquipmentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer equipmentId;
    private String equipmentName;
    private String contactPerson;
    private String mobileNumber;
    private Integer quantityCount;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Integer getQuantityCount() {
		return quantityCount;
	}
	public void setQuantityCount(Integer quantityCount) {
		this.quantityCount = quantityCount;
	}
	public EquipmentDetails(Integer bookingId, Integer equipmentId, String equipmentName, String contactPerson,
			String mobileNumber, Integer quantityCount) {
		super();
		this.bookingId = bookingId;
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.quantityCount = quantityCount;
	}
	public EquipmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EquipmentDetails(Integer equipmentId, String equipmentName, String contactPerson, String mobileNumber,
			Integer quantityCount) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.quantityCount = quantityCount;
	}
	
	
    
    
} 
