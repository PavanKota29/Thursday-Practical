package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.spring.entity.EmployeeTable;
import com.spring.repo.EmpRepo;

@Component
public class EmpServices {
	
	@Autowired
	public EmpRepo ep;
	
	//get All Employee Details
	public ResponseEntity<List<EmployeeTable>> getEmployee(){
		if(ep.findAll().size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(ep.findAll());
		}
	}
	
	//get Employee Data By Id
	public ResponseEntity<EmployeeTable> getEmployee(int id){
		try {
			return ResponseEntity.ok(ep.findById(id).get());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Insert Employee Data 
	public ResponseEntity<String> insertEmployee(EmployeeTable e){
		try {
			ep.save(e);
			return ResponseEntity.ok("Employee Data Inserted !!!!!");
		}catch (Exception e1) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No ID Found !!!");
		}
	}
	
	//Update Employee Data
	public ResponseEntity<String> updateEmployee(int id,EmployeeTable e){
		try {
			Optional<EmployeeTable> op=ep.findById(id);
			EmployeeTable e1=op.get();	
			e1.setAge(e.getAge());
			e1.setEname(e.getEname());
			e1.setSal(e.getSal());
			ep.save(e1);
			return ResponseEntity.ok("Employee Data Updated !!!!!");
		} catch (Exception e2) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Not Found !!!! ");
		}
	}
	
	//delete Employee Data
	public ResponseEntity<String> deleteEmployee(int id){
		try {
			ep.deleteById(id);
			return ResponseEntity.ok("Employee Data Deleted !!!!!!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Not Found !!!!");
		}
	}
	
}
