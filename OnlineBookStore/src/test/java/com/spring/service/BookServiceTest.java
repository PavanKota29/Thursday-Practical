package com.spring.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.entity.Author;
import com.spring.entity.Book;
import com.spring.repo.AuthorRepo;
import com.spring.repo.BookRepo;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepo bookRepo;

    @Mock
    private AuthorRepo authorRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBooks() {
        // Prepare test data
        Author author = new Author();
        author.setAid(1L);
        Book book = new Book();
        book.setAuthor(author);

        // Mock dependencies
        when(authorRepo.findById(1L)).thenReturn(Optional.of(author));
        when(bookRepo.save(any(Book.class))).thenReturn(book);

        // Execute the method
        ResponseEntity<String> response = bookService.addBooks(book);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("insert", response.getBody());
    }

    @Test
    public void testUpdateBooks() {
        // Prepare test data
        Long bookId = 1L;
        Long authorId = 2L;

        Author author = new Author();
        author.setAid(authorId);

        Book existingBook = new Book();
        existingBook.setBid(bookId);

        Book updatedBook = new Book();
        updatedBook.setBid(bookId);
        updatedBook.setAuthor(author);

        // Mock dependencies
        when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
        when(bookRepo.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepo.save(any(Book.class))).thenReturn(updatedBook);

        // Execute the method
        ResponseEntity<String> response = bookService.updateBooks(bookId, updatedBook);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("update", response.getBody());
    }

    @Test
    public void testDeleteBooks() {
        // Prepare test data
        Long bookId = 1L;

        Book book = new Book();
        book.setBid(bookId);

        // Mock dependencies
        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));

        // Execute the method
        ResponseEntity<String> response = bookService.deleteBooks(bookId);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("delete", response.getBody());
    }


    @Test
    public void testGetAllBooks() {
        // Prepare test data
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());

        // Mock dependencies
        when(bookRepo.findAll()).thenReturn(books);

        // Execute the method
        ResponseEntity<List<Book>> response = bookService.getAllBooks();

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetBooks() {
        // Prepare test data
        Long bookId = 1L;
        Book book = new Book();
        book.setBid(bookId);

        // Mock dependencies
        when(bookRepo.findById(bookId)).thenReturn(Optional.of(book));

        // Execute the method
        ResponseEntity<Book> response = bookService.getBooks(bookId);

        // Verify the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    public void testGetBooksNotFound() {
        // Prepare test data
        Long bookId = 1L;

        // Mock dependencies
        when(bookRepo.findById(bookId)).thenReturn(Optional.empty());

        // Execute the method
        ResponseEntity<Book> response = bookService.getBooks(bookId);

        // Verify the result
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
