package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.Books;
import com.javatpoint.model.ResponseObject;

public interface BookServiceI {

	public List<Books> getAllBooks();

	public Books saveOrUpdate(Books books);

	//public Books getBookById(int bookid);
	
	public ResponseObject getBookById(int bookid);
}
