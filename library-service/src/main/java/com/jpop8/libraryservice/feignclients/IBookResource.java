package com.jpop8.libraryservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpop8.libraryservice.wrappers.Book;
import com.jpop8.libraryservice.wrappers.BooksWrapper;

@FeignClient(value = "${bookservice.name}")
public interface IBookResource {
	@GetMapping("${bookservice.api.prefix}")
	BooksWrapper getAllBooks();

	@GetMapping("${bookservice.api.prefix}/{id}")
	Book getBookById(@PathVariable Long id);

	@GetMapping("${bookservice.api.prefix}/tags/{tags}")
	public BooksWrapper getBookByTags(@PathVariable("tags") String tags);

	@PostMapping("${bookservice.api.prefix}")
	public Book createBook(@RequestBody Book book);

	@PutMapping("${bookservice.api.prefix}/{id}")
	public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book);

	@DeleteMapping("${bookservice.api.prefix}/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id);
}
