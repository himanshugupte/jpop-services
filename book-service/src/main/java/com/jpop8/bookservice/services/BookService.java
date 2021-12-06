package com.jpop8.bookservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpop8.bookservice.exceptions.ResourceNotFoundException;
import com.jpop8.bookservice.models.Book;
import com.jpop8.bookservice.repository.BookCategoryRepository;
import com.jpop8.bookservice.repository.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	private BookCategoryRepository bookCategoryRepository;

	public BookService(BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
		this.bookRepository = bookRepository;
		this.bookCategoryRepository = bookCategoryRepository;
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
		book.setBookCategory(bookCategoryRepository.getById(1L));
		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		book.setBookCategory(bookCategoryRepository.getById(1L));
		return bookRepository.save(book);
	}
	
	

}
