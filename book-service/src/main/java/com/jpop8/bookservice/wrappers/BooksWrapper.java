package com.jpop8.bookservice.wrappers;

import java.util.ArrayList;
import java.util.List;

import com.jpop8.bookservice.models.Book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BooksWrapper {
	private List<Book> books;

	public BooksWrapper() {
		books = new ArrayList<>();
	}
}
