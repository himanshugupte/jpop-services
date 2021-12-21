package com.jpop8.libraryservice.wrappers;

import java.util.ArrayList;
import java.util.List;

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

