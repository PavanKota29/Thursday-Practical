package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.entity.Author;
import com.spring.entity.Book;
import com.spring.repo.AuthorRepo;
import com.spring.repo.BookRepo;

@Service
public class AuthorService {
	@Autowired
	public AuthorRepo a;
	
	@Autowired
	public BookRepo b;

	//Getting Author details
	public ResponseEntity<List<Author>> getAllAuthor(){
		
		if(a.findAll().size() <=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(a.findAll());
		}
	}
	
	//Getting Author details based on id
	public ResponseEntity<Author> getAuthor(Long aid){
		try {
			return ResponseEntity.ok(a.findById(aid).get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Insert Author Details in table
	public ResponseEntity<String> addAuthor(Author author){
		try {
			a.save(author);
			return ResponseEntity.ok("insert");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	}	
	
	//Update Author Details
	public ResponseEntity<String> updateAuthor(Long aid,Author author){
		try {
			
			Optional<Author> op=a.findById(aid);
			Author a1=op.get();
			a1.setAemail(author.getAemail());
			a1.setAname(author.getAname());
			a.save(a1);
			
			return ResponseEntity.ok("update");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//delete Author Details
	public ResponseEntity<String> deleteAuthor(Long aid){
		try {
			Author a1=a.findById(aid).get();
			List<Book> b1=a1.getBook();
			b.deleteAll(b1);
			a.save(a1);
			a.deleteById(aid);
			return ResponseEntity.ok("delete");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error");
		}
	}
	
}
