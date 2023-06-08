package com.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

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


class AuthorServiceTest {

    @Mock
    private AuthorRepo authorRepo;

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAuthor() {
        // Create a mock Author object
        Author author = new Author();
        author.setAname("John Doe");
        author.setAemail("johndoe@example.com");

        // Set up the behavior of the authorRepo mock
        when(authorRepo.save(author)).thenReturn(author);

        // Call the method under test
        ResponseEntity<String> response = authorService.addAuthor(author);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("insert", response.getBody());

        // Verify that the save method was called on authorRepo mock
        verify(authorRepo).save(author);
    }

    @Test
    void testUpdateAuthor() {
        // Create a mock Author object
        Author author = new Author();
        author.setAname("John Doe");
        author.setAemail("johndoe@example.com");

        // Set up the behavior of the authorRepo mock
        when(authorRepo.findById(1L)).thenReturn(Optional.of(author));
        when(authorRepo.save(author)).thenReturn(author);

        // Call the method under test
        ResponseEntity<String> response = authorService.updateAuthor(1L, author);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("update", response.getBody());

        // Verify that the findById and save methods were called on authorRepo mock
        verify(authorRepo).findById(1L);
        verify(authorRepo).save(author);
    }

    @Test
    void testDeleteAuthor() {
        // Create a mock Author object
        Author author = new Author();
        author.setAname("John Doe");
        author.setAemail("johndoe@example.com");

        // Set up the behavior of the authorRepo and bookRepo mocks
        when(authorRepo.findById(1L)).thenReturn(Optional.of(author));
        when(authorRepo.save(author)).thenReturn(author);
        when(authorRepo.findAll()).thenReturn(new ArrayList<>());

        // Call the method under test
        ResponseEntity<String> response = authorService.deleteAuthor(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("delete", response.getBody());

        // Verify that the findById, deleteById, and deleteAll methods were called on authorRepo and bookRepo mocks
        verify(authorRepo).findById(1L);
        verify(bookRepo).deleteAll(author.getBook());
        verify(authorRepo).deleteById(1L);
        verify(authorRepo).save(author);
    }

    @Test
    void testGetAllAuthorWhenEmpty() {
        // Set up the behavior of the authorRepo mock
        when(authorRepo.findAll()).thenReturn(new ArrayList<>());

        // Call the method under test
        ResponseEntity<List<Author>> response = authorService.getAllAuthor();

        // Verify the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        // Verify that the findAll method was called on authorRepo mock
        verify(authorRepo).findAll();
    }


    @Test
    void testGetAuthor() {
        // Create a mock Author object
    	List<Book> book = new ArrayList<>();
        Author author = new Author(1L, "John Doe", "johndoe@example.com",book);

        // Set up the behavior of the authorRepo mock
        when(authorRepo.findById(1L)).thenReturn(Optional.of(author));

        // Call the method under test
        ResponseEntity<Author> response = authorService.getAuthor(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(author, response.getBody());

        // Verify that the findById method was called on authorRepo mock
        verify(authorRepo).findById(1L);
    }
}

