package com.jpop8.libraryservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jpop8.libraryservice.feignclients.IBookResource;
import com.jpop8.libraryservice.wrappers.Book;
import com.jpop8.libraryservice.wrappers.BooksWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryResource {

	@Value("${bookservice.api.version}")
	private String bookApiVersion;

	@Autowired
	private IBookResource bookResource;

	@GetMapping("/v1.0/books")
	public BooksWrapper getBooksInLibrary() {
		log.info("Fetching books for API version: {}", bookApiVersion);
		return bookResource.getAllBooks();
	}

	@GetMapping("/v1.0/books/{id}")
	public Book getBooksInLibraryById(@PathVariable Long id) {
		log.info("Fetching books for API version: {}", bookApiVersion);
		return bookResource.getBookById(id);
	}
}
