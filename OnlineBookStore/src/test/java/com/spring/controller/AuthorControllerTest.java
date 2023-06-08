package com.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.entity.Author;
import com.spring.entity.Book;
import com.spring.repo.AuthorRepo;
import com.spring.repo.BookRepo;
import com.spring.service.AuthorService;

@SpringBootTest
class AuthorControllerTest {
	 	@Mock
	    private AuthorRepo authorRepoMock;

	    @Mock
	    private BookRepo bookRepoMock;

	    @InjectMocks
	    private AuthorService authorService;

	    @Test
	    public void testAddAuthor() {
	    	
	    	// Prepare
	        Author author = new Author();
	        when(authorRepoMock.save(author)).thenReturn(author);
	        
	        // Execute
	        ResponseEntity<String> response = authorService.addAuthor(author);
	        
	        // Verify
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("insert", response.getBody());
	        verify(authorRepoMock, times(1)).save(author);
	    }

	    @Test
	    public void testAddAuthor_Error() {
	    	
	    	// Prepare
	        Author author = new Author();
	        when(authorRepoMock.save(author)).thenThrow(new RuntimeException());
	        
	        // Execute
	        ResponseEntity<String> response = authorService.addAuthor(author);

	        // Verify
	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	        assertEquals("Error", response.getBody());
	        verify(authorRepoMock, times(1)).save(author);
	    }

	    @Test
	    public void testUpdateAuthor() {
	    	
	    	// Prepare
	    	List<Book> book=new ArrayList<>();
	 
	        Long authorId = 1L;
	        Author existingAuthor = new Author();
	        existingAuthor.setAid(authorId);

	        Author updatedAuthor = new Author();
	        updatedAuthor.setAname("John Doe");
	        updatedAuthor.setAemail("john.doe@example.com");
	        updatedAuthor.setBook(book);
	        
	        
	        when(authorRepoMock.findById(authorId)).thenReturn(Optional.of(existingAuthor));
	        when(authorRepoMock.save(existingAuthor)).thenReturn(existingAuthor);
	        
	        // Execute
	        ResponseEntity<String> response = authorService.updateAuthor(authorId, updatedAuthor);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("update", response.getBody());
	        assertEquals(updatedAuthor.getAname(), existingAuthor.getAname());
	        assertEquals(updatedAuthor.getAemail(), existingAuthor.getAemail());
	    
	        // Verify
	        verify(authorRepoMock, times(1)).findById(authorId);
	        verify(authorRepoMock, times(1)).save(existingAuthor);
	    }

	    @Test
	    public void testUpdateAuthor_NotFound() {
	    	
	    	// Prepare
	        Long authorId = 1L;
	        Author updatedAuthor = new Author();

	        when(authorRepoMock.findById(authorId)).thenReturn(Optional.empty());
	     
	        // Execute
	        ResponseEntity<String> response = authorService.updateAuthor(authorId, updatedAuthor);

	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	     
	        // Verify
	        verify(authorRepoMock, times(1)).findById(authorId);
	    }


	    @Test
	    public void testDeleteAuthor_NotFound() {
	    	
	    	// Prepare
	        Long authorId = 1L;

	        when(authorRepoMock.findById(authorId)).thenReturn(Optional.empty());
	        
	        // Execute
	        ResponseEntity<String> response = authorService.deleteAuthor(authorId);

	        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	   
	        // Verify
	        verify(authorRepoMock, times(1)).findById(authorId);
	    }

	    @Test
	    public void testGetAllAuthor_NoContent() {
	    	
	    	// Prepare
	        when(authorRepoMock.findAll()).thenReturn(new ArrayList<>());
	        
	        // Execute
	        ResponseEntity<List<Author>> response = authorService.getAllAuthor();

	        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	    
	        // Verify
	        verify(authorRepoMock, times(1)).findAll();
	    }


	    @Test
	    public void testGetAuthor() {
	    	
	    	// Prepare
	        Long authorId = 1L;
	        Author author = new Author();

	        when(authorRepoMock.findById(authorId)).thenReturn(Optional.of(author));
	        
	        // Execute
	        ResponseEntity<Author> response = authorService.getAuthor(authorId);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(author, response.getBody());
	  
	        // Verify
	        verify(authorRepoMock, times(1)).findById(authorId);
	    }

	    @Test
	    public void testGetAuthor_NotFound() {
	    	// Prepare
	        Long authorId = 1L;

	        when(authorRepoMock.findById(authorId)).thenReturn(Optional.empty());
	    
	        // Execute
	        ResponseEntity<Author> response = authorService.getAuthor(authorId);

	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	     
	        // Verify
	        verify(authorRepoMock, times(1)).findById(authorId);
	    }
	}
