package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.EmployeeTable;
import com.spring.service.EmpServices;



@RestController
class EmpContoller {
	
	@Autowired
	private EmpServices emp;

	
	@GetMapping("/getEmp")
	public ResponseEntity<List<EmployeeTable>> getallEmp() {
		return this.emp.getEmployee();
	}
	
	@PostMapping("/insertEmp")
	public ResponseEntity<String> insertEmpoyee(@RequestBody EmployeeTable e) {
			return this.emp.insertEmployee(e);	
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<EmployeeTable> getEmpid(@PathVariable("id") int id) {
		return this.emp.getEmployee(id);
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<String> updateEmp(@PathVariable("id") int id,@RequestBody EmployeeTable e) {
		return this.emp.updateEmployee(id, e);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") int id) {
		return this.emp.deleteEmployee(id);
	}
}
