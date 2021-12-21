package com.jpop8.libraryservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jpop8.libraryservice.wrappers.BooksWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryResource {

	@Value("${service.api.version}")
	private String apiVersion;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/v1.0/books")
	public BooksWrapper getBooksInLibrary() {
		log.info("Fetching books for API version: {}", apiVersion);
		BooksWrapper allBooksInLibrary = restTemplate.getForObject(getBookUrl(apiVersion), BooksWrapper.class);
		return allBooksInLibrary;
	}

	private String getBookUrl(String suffix) {
		return String.format("http://BOOK-SERVICE/api/books/%s", suffix);
	}
}
