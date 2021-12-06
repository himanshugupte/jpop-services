package com.jpop8.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpop8.bookservice.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	public List<Book> findByNameContaining(String name);
}
