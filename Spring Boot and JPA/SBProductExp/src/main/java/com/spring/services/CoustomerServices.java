package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.entity.Coustomer;
import com.spring.repo.CoustomerRepo;

@Service
public class CoustomerServices {
	
	@Autowired
	private CoustomerRepo cr;
	
	//Getting All Coustomer Details
	public ResponseEntity<List<Coustomer>> getAllCoustomer(){
		if(cr.findAll().size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.ok(cr.findAll());
		}
	}
	
	//Getting Coustomer Details by id
	public ResponseEntity<Coustomer> getCoustomer(int id){
		try {
			return ResponseEntity.ok(cr.findById(id).get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Inserting Coustomer details
	public ResponseEntity<String> insertCoustomer(Coustomer c){
		try {
			cr.save(c);
			return ResponseEntity.ok("Data Inserted Successfully !!!!!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	}
	
	//Updating the coustomer	
	public ResponseEntity<String> updateCoustomer(int id,Coustomer c){
		try {
			Coustomer cc=cr.findById(id).get();
			cc.setCname(c.getCname());
			cc.setEmail(c.getEmail());
			cc.setMobileno(c.getMobileno());
			cc.setProduct(c.getProduct());
			cr.save(cc);
			return ResponseEntity.ok("Data Updated Successfully");			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
		}
	}
	
	//Delete the Coustomer	
	public ResponseEntity<String> deleteCoustomer(int id){
		try {
			cr.deleteById(id);
			return ResponseEntity.ok("Data Deleted Successfully !!!!!!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
		}
	}
}
