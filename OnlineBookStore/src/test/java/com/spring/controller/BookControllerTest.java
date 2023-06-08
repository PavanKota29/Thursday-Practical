package com.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.entity.Author;
import com.spring.entity.Book;
import com.spring.service.AuthorService;
import com.spring.service.BookService;

class BookControllerTest {
	
	@Mock
	private AuthorService authorservice;
	
	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllBooks() {
		// Prepare
		List<Book> books = new ArrayList<>();
		books.add(new Book(0L,"abc",new Author(0L,"xyz","xyz@gmail.com",books),"290"));
		books.add(new Book(0L,"abc",new Author(0L,"xyz","xyz@gmail.com",books),"290"));

		when(bookService.getAllBooks()).thenReturn(ResponseEntity.ok(books));

		// Execute
		ResponseEntity<List<Book>> response = bookController.getAllBooks();

		// Verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(books, response.getBody());
	}

	@Test
	public void testGetBooks() {
		// Prepare
		Long bookId = 1L;
		List<Book> books = new ArrayList<>();
		Book book = new Book(1L,"abc",new Author(0L,"xyz","xyz@gmail.com",books),"290");

		when(bookService.getBooks(bookId)).thenReturn(ResponseEntity.ok(book));

		// Execute
		ResponseEntity<Book> response = bookController.getBooks(bookId);

		// Verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(book, response.getBody());
	}

	@Test
	public void testAddBooks() {
		// Prepare
		List<Book> books = new ArrayList<>();
		Book book = new Book(1L,"abc",new Author(0L,"xyz","xyz@gmail.com",books),"290");

		when(bookService.addBooks(any(Book.class))).thenReturn(ResponseEntity.ok("insert"));

		// Execute
		ResponseEntity<String> response = bookController.addBooks(book);

		// Verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("insert", response.getBody());
	}


	@Test
	public void testDeleteBooks() {
		// Prepare
		Long bookId = 1L;

		when(bookService.deleteBooks(bookId)).thenReturn(ResponseEntity.ok("delete"));

		// Execute
		ResponseEntity<String> response = bookController.deleteBooks(bookId);

		// Verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("delete", response.getBody());
	}

}
