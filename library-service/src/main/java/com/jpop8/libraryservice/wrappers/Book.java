package com.jpop8.libraryservice.wrappers;

import lombok.Data;

@Data
public class Book {
	private Long id;

	private String name;

	private String description;

	private String imageUrl;

}
