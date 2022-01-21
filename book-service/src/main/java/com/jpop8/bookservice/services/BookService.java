package com.jpop8.bookservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpop8.bookservice.exceptions.ResourceNotFoundException;
import com.jpop8.bookservice.models.Book;
import com.jpop8.bookservice.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks(String name) {
		if(name == null) {
			return bookRepository.findAll();			
		} else {
			return bookRepository.findByNameContaining(name);
		}
	}

	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> getBookByTags(String tags) {
		return bookRepository.findByTagsContaining(tags);
	}
}
