package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Books;
import com.javatpoint.model.ResponseObject;
import com.javatpoint.service.BookServiceI;

@RestController
public class BooksControllerResponseEntity {
	@Autowired
	BookServiceI booksService;

	HttpHeaders headers = new HttpHeaders();
	
	@GetMapping("/getbooks")
	private ResponseEntity<List<Books>> getAllBooks() {
		List<Books> books = booksService.getAllBooks();
		return ResponseEntity.ok().headers(headers).body(books);
	}

	@PostMapping("/createBook")
	private ResponseEntity<Books> saveBook(@RequestBody Books books) {
		Books sbooks = booksService.saveOrUpdate(books);
		
		return ResponseEntity.ok().headers(headers).body(sbooks);
	}

//	@GetMapping("/getbooks/{bookid}")
//	private ResponseEntity<Books> getBookById(@PathVariable("bookid")int bookid) {
//		Books book = booksService.getBookById(bookid);
//		return ResponseEntity.ok().headers(headers).body(book);
//	}

	@GetMapping("/getbooks/{bookid}")
	private ResponseEntity<ResponseObject> getBookById(@PathVariable("bookid")int bookid) {
		ResponseObject res =  booksService.getBookById(bookid);
		//Books book = booksService.getBookById(bookid);
		return ResponseEntity.ok().headers(headers).body(res);
	}
	
	
}
