

package com.dnapass.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;
//import com.dnapass.training.entity.ItemDetails;
//import com.dnapass.training.entity.Item;
import com.dnapass.training.entity.Item;
import com.dnapass.training.entity.ItemDetails;
import com.dnapass.training.entity.Login;
import com.dnapass.training.entity.User;
import com.dnapass.training.service.EquipmentService;
import com.dnapass.training.service.ItemService;
import com.dnapass.training.service.UserService;

@RestController
@RequestMapping("/farmmarket")
@Component
public class FarmMarketController {
	@Autowired
	UserService userservice;
	
	@Autowired
	ItemService itemservice;
	
	@Autowired
	EquipmentService equipmentservice;

	// Mapping with /login with requestbody login
	@GetMapping("/login")
	public ResponseEntity<Object> checkLogin(@RequestBody Login login) {
		try {
			User findUser = userservice.findUser(login.getUserid());
			return new ResponseEntity<>(findUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}

	
	
	// Mapping with "/newuser"
	@PostMapping("/newuser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User savedUser = userservice.saveUser(user);
			return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
//	Mapping with "/search" based on city parameter
	@GetMapping("/search")
	public ResponseEntity<List<Equipment>> farmerSearchEquipment(@RequestParam("city") String city) {
			List<Equipment> equipList=equipmentservice.searchEquipment(city);
			return new ResponseEntity<List<Equipment>>(equipList,HttpStatus.OK);
		
		
		
	}

	//Mapping with "/getAllEquipment"
	@GetMapping("/getAllEquipment")
	public ResponseEntity<List<Equipment>> getAllEquipment() {
		List<Equipment> eqList=new ArrayList<Equipment>();
		equipmentservice.getAllEquipment().forEach(eqList::add);
		
	    return new ResponseEntity<List<Equipment>>(eqList,HttpStatus.OK);
	}
	
	//Mapping with "/getAllEquipmentById/{id} based on user id 
	@GetMapping("/getAllEquipmentById/{id}")
	public ResponseEntity<List<Equipment>> getAllEquipmentById(@PathVariable("id")Integer id) {
		try {
			List<Equipment> eqList1= equipmentservice.getAllEquipmentById(id);
			return new ResponseEntity<List<Equipment>>(eqList1,HttpStatus.OK);
					}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//Mapping with "/getAllItemById/{id}" based on user id
	@GetMapping("/getAllItemById/{id}")
	public ResponseEntity<List<Item>> getAllItemById(@PathVariable("id")Integer id) {
		List<Item> ItemList1=itemservice.getAllItemById(id);
	    return new ResponseEntity<List<Item>>(ItemList1,HttpStatus.OK);
	}

	// Mapping wih "/book/{equipId}/{userid}/{quantitycount}" to book an equipment based on equipment id, user id and number of quantity
	@PutMapping("/book/{equipId}/{userid}/{quantitycount}")
	public ResponseEntity<Equipment> bookEquipment(@PathVariable("equipId") Integer id,@PathVariable("quantitycount") Integer ecount,@PathVariable("userid")Integer uid) {
		try {
			Equipment findEquipment = equipmentservice.getEquipmentById(id);
			findEquipment.setCount(findEquipment.getCount() - ecount);
			equipmentservice.addEquipment(findEquipment);
			return new ResponseEntity<>(findEquipment, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Mapping with "/addNewItem/{id}" based on particular userid with Item body
	@PostMapping("/addNewItem/{id}")
	public ResponseEntity<Item> addNewItem(@RequestBody Item item, @PathVariable("id") Integer userId) {
		Item item1=itemservice.addNewItem(item);
	     return new ResponseEntity<Item>(item1,HttpStatus.CREATED);
	} 

	// Mapping with "/getAllItems" to return all items for traders to view
	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemDetails>> getAllItems() {
		 List<ItemDetails> IdList= new ArrayList<>();
		 itemservice.getAllItems().forEach(IdList::add); 
		return new ResponseEntity<List<ItemDetails>>(IdList,HttpStatus.OK);
	}

	// Mapping with "/deleteItemDetails/{itemId}" to delete item based on itemId
	@DeleteMapping("/deleteItemDetails/{itemId}")
	public ResponseEntity<HttpStatus> deleteItemDetails(@PathVariable("itemId") Integer itemId) {
		itemservice.deleteItemDetails(itemId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	// Mapping with "/itemDetails/{uid}" to update the items based on particular
	// user with body Item
	public ResponseEntity<Item> updateItemDetails(@PathVariable("uid") Integer userId,
			@RequestBody Item item) {
	    return null;
	}

	// Mapping with "/addNewEquipment/{id}" to add new equipment for particular
	// userid with equipment body
	@PostMapping("/addNewEquipment/{id}")
	public ResponseEntity<Equipment> addNewEquipment(@RequestBody Equipment equipment,
			@PathVariable("id") Integer userId) {
		   Equipment equipment1 = equipmentservice.addEquipment(equipment);
	     return new ResponseEntity<Equipment>(equipment1,HttpStatus.CREATED);
	}

	//Mapping with "/getAllEquipments" to display all equipment for farmer based on count
	@GetMapping("/getAllEquipments")
	public ResponseEntity<List<Equipment>> getAllEquipments() {
		List<Equipment> eqList=equipmentservice.getAllEquipment();
		return new ResponseEntity<List<Equipment>>(eqList,HttpStatus.OK);
	}

	// Mapping with "/deleteEquipmentDetails/{equipId}" to delete particular
	// equipment based on equipment id
	@DeleteMapping("/deleteEquipmentDetails/{equipId}")
	public ResponseEntity<HttpStatus> deleteEquipmentDetails(@PathVariable("equipId") Integer equipId) {
		equipmentservice.deleteEquipmentDetail(equipId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	//Mapping with "/equipmentDetails/{uid}" to update equipment detail based on particular user with equipment body
	@PutMapping("/equipmentDetails/{uid}")
	public ResponseEntity<Equipment> updateEquipmentDetails(
			@PathVariable("uid") Integer userId, @RequestBody Equipment equipment) {
		try {
			Equipment updateEquipment = equipmentservice.getEquipmentById(userId);
			equipmentservice.deleteEquipmentDetail(userId);
			updateEquipment.setName(equipment.getName());
			updateEquipment.setCount(equipment.getCount());
			updateEquipment.setRentPerDay(equipment.getRentPerDay());
			updateEquipment.setContactPerson(equipment.getContactPerson());
			updateEquipment.setMobileNumber(equipment.getMobileNumber());
			equipmentservice.addEquipment(updateEquipment);
			return new ResponseEntity<>(updateEquipment, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Mapping with "/returnEquipment" to return an equipment and update the count
	@PutMapping("/returnEquipment")
	public ResponseEntity<Equipment> returnEquipment(@RequestBody EquipmentDetails edetails) {
		try {
			Equipment returnEquipmentDetail = equipmentservice.getEquipmentById(edetails.getEquipmentId());
			returnEquipmentDetail.setCount(returnEquipmentDetail.getCount() + edetails.getQuantityCount());
			equipmentservice.addEquipment(returnEquipmentDetail);
			return new ResponseEntity<>(returnEquipmentDetail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	 Mapping with "/getHiredEquipment/{id}" to view hired equipment based on
//	 booking id
	@GetMapping("/getHiredEquipment/{id}")
	public ResponseEntity<List<EquipmentDetails>> getHiredEquipment(@PathVariable("id")Integer id) {
		 List<EquipmentDetails> eqDlist = equipmentservice.getHiredEquipment(id);
		 return new ResponseEntity<List<EquipmentDetails>>(eqDlist,HttpStatus.OK) ;
	}
	
	
	
	//Mapping with "/searchItem" to search the item by trader based on city
	@GetMapping("/searchItem")
	public ResponseEntity<List<ItemDetails>> traderSearchItem(@RequestParam("city") String city) {
		  List<ItemDetails> itemList= itemservice.searchItem(city);
	      return new ResponseEntity<List<ItemDetails>>(itemList,HttpStatus.OK);
	}

	// Mapping with "/getFarmer/{id}" to display all items for that farmer based on
	// userid
	@GetMapping("/getFarmer/{id}")
	public ResponseEntity<User> getFarmerDetails(@PathVariable("id") Integer id) {
		try {
			User getFarmerDetails = userservice.findUser(id);
			if (!getFarmerDetails.getRole().equalsIgnoreCase("farmer"))
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(getFarmerDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	//Mapping with "/orderItem/{itemId}" by trader based on itemid and update the count of items
	@PutMapping("/orderItem/itemId")
	public ResponseEntity<ItemDetails> orderItem(@PathVariable("itemId") Integer id) {
		try {
			Item item = itemservice.getItemById(id);
			item.setItemQuantity(item.getItemQuantity() - 1);
			ItemDetails itemDetails = new ItemDetails(item.getItemId(), item.getItemName(), item.getItemQuantity(),
					item.getUser().getUsername(), item.getUser().getMobileNumber(), item.getUser().getId());
			itemservice.deleteItemDetails(id);
			itemservice.addNewItem(item);
			return new ResponseEntity<>(itemDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
