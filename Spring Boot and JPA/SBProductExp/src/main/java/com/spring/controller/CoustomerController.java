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

import com.spring.entity.Coustomer;
import com.spring.services.CoustomerServices;

@RestController
public class CoustomerController {
	
	@Autowired
	private CoustomerServices cs;
	
	@GetMapping("/getAllCoustomer")
	public ResponseEntity<List<Coustomer>> getAllCoustomer(){
		return cs.getAllCoustomer();
	}
	
	@GetMapping("/getCoustomer/{id}")
	public ResponseEntity<Coustomer> getCoustomer(@PathVariable("id") int id){
		return cs.getCoustomer(id);
	}
	
	@PostMapping("/insertCoustomer")
	public ResponseEntity<String> insertCoustomer(@RequestBody Coustomer c){
		return cs.insertCoustomer(c);
	}
	
	@PutMapping("/updateCoustomer/{id}")
	public ResponseEntity<String> updateCoustomer(@PathVariable("id") int id,@RequestBody Coustomer c){
		return cs.updateCoustomer(id, c);
	}
	
	@DeleteMapping("/deleteCoustomer/{id}")
	public ResponseEntity<String> deleteCoustomer(@PathVariable("id") int id){
		return cs.deleteCoustomer(id);
	}
	
	
}
