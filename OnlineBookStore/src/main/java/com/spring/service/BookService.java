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
public class BookService {
	
	@Autowired
	public BookRepo b;
	
	@Autowired
	public AuthorRepo a;
	
	//Getting All Book Details
	public ResponseEntity<List<Book>> getAllBooks(){
		
		if(b.findAll().size() <=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(b.findAll());
		}
	}
	
	//Getting Book details based on id
	public ResponseEntity<Book> getBooks(Long bid){
		try {
			return ResponseEntity.ok(b.findById(bid).get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Inserted Book details in table
	public ResponseEntity<String> addBooks(Book book){
		try {
			Long id=book.getAuthor().getAid();
			Author aut=a.findById(id).get();
			book.setAuthor(aut);
			b.save(book);
			return ResponseEntity.ok("insert");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	}	
	
	
	//Update the Book Details
	public ResponseEntity<String> updateBooks(Long bid,Book book){
		try {
			Long id=book.getAuthor().getAid();
			Author aut=a.findById(id).get();
			book.setAuthor(aut);
			
			Optional<Book> op=b.findById(bid);
			Book b1=op.get();
			b1.setBname(book.getBname());
			b1.setAuthor(book.getAuthor());
			b1.setPrice(book.getPrice());
			b.save(b1);
			
			return ResponseEntity.ok("update");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//Delete the Book details 	
	public ResponseEntity<String> deleteBooks(Long bid){
		try {
			Book b1=b.findById(bid).get();
			b1.setAuthor(null);
			b.save(b1);
			b.deleteById(bid);
			return ResponseEntity.ok("delete");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	
}
