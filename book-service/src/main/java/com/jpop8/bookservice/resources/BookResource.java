package com.jpop8.bookservice.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpop8.bookservice.config.SwaggerConfig;
import com.jpop8.bookservice.models.Book;
import com.jpop8.bookservice.services.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/books")
@Api(tags = {SwaggerConfig.BOOK_TAG})
public class BookResource {

	private BookService bookService;

	public BookResource(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/v1.0")
	@ApiOperation(value = "View a list of books, pass '?name=' to filter by name")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String name) {
		log.debug("Going to fetch books");
		return new ResponseEntity<>(bookService.getAllBooks(name), HttpStatus.OK);
	}

	@GetMapping("/v1.0/{id}")
	@ApiOperation(value = "View a book by id")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
		log.debug("Going to fetch book by id: {}", id);
		Book book = bookService.getBookById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping("/v1.0/tags/{tags}")
	@ApiOperation(value = "View a list of books by tags")
	public ResponseEntity<List<Book>> getBookByTags(@PathVariable("tags") String tags) {
		log.debug("Going to fetch book by tags: {}", tags);
		return new ResponseEntity<>(bookService.getBookByTags(tags), HttpStatus.OK);
	}

	@PostMapping("/v1.0")
	@ApiOperation(value = "Create a book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		log.debug("Going to create book: {}", book);
		return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/v1.0")
	@ApiOperation(value = "Update a book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		log.debug("Going to update book by id: {}", book.getId());
		bookService.getBookById(book.getId());
		return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1.0/{id}")
	@ApiOperation(value = "Delete a book by id")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
		try {
			bookService.deleteBookById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
