package com.dnapass.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;
import com.dnapass.training.entity.EquipmentUser;
//import com.dnapass.training.repository.EquipmentRepository;
import com.dnapass.training.repository.EquipmentRepository;
import com.dnapass.training.repository.EquipmentUserRepository;

@Service
public class EquipmentService {

	@Autowired
	EquipmentRepository equipmentrepo;
	
	@Autowired
	EquipmentUserRepository equipmentuserrepo;

	public List<Equipment> searchEquipment(String city) {
		List<Equipment> searchCity = equipmentrepo.findByCity(city);
		return searchCity;

	}

	//To fetch all equipmnet for the farmers to book it 
	public List<Equipment> getAllEquipment() {
		boolean test = false;
		if(test) {
			List<Equipment> equipmentList= equipmentrepo.findAll();
			return equipmentList;
		}
		else {
			List<Equipment> equipmentListCount = equipmentrepo.findEquipmentByCount();
			return equipmentListCount;
		}
		
	}

	//To add new equipment 
	public Equipment addEquipment(Equipment e) {
		Equipment saveEquipment = new Equipment(e.getId(),e.getName(), e.getCount(),e.getRentPerDay(),
				e.getState(),e.getCity(),e.getVillage(),e.getPincode(),e.getContactPerson(),e.getMobileNumber(),e.getStatus(), e.getUser());
		equipmentrepo.save(saveEquipment);
		return saveEquipment;
	}

    //To delete particular equipment based on equipment id 
	public void deleteEquipmentDetail(Integer equipId) {
		equipmentrepo.deleteById(equipId);
		
	}

   //To get an equipment based on id 
	public Equipment getEquipmentById(Integer id) {
		Equipment equipmentId= equipmentrepo.findById(id).get();
		return equipmentId;
		
	}

    //To fetch all equipment for that particular user 
	public List<Equipment> getAllEquipmentById(Integer id) {
		return equipmentrepo.findAllEquipment(id);
	}
	
	//To fetch all hired equipment for particular user 
	public List<EquipmentDetails> getHiredEquipment(Integer uid){
		return equipmentrepo.findHiredEquipment(uid);
	}
	
	//To add new equipmentuser which contains both equipment details and user details 
	public EquipmentUser addEquipmentUser(EquipmentUser euser) {
		return  equipmentuserrepo.save(new EquipmentUser(euser.getId(),euser.getUser(),euser.getEquipment(),euser.getQuantity()));
	
	}
	
	//To delete equipment based on bookingid while returning the equipment
	public void deleteEquipmentUser(Integer bookingId) {
		equipmentrepo.deleteById(bookingId);
	}
}