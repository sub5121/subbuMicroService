package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Books;
import com.javatpoint.model.ResponseObject;
import com.javatpoint.repository.BooksRepository;
//defining the business logic
@Service
public class BooksService implements BookServiceI
{
@Autowired
BooksRepository booksRepository;

@Override
public List<Books> getAllBooks() {
	{
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
		}
}

@Override
public Books saveOrUpdate(Books books) {
	return booksRepository.save(books);
}

//@Override
//public Books getBookById(int bookid) {
//	Optional<Books> b = booksRepository.findById(bookid);
//	return booksRepository.findById(bookid).get();
//}

@Override
public ResponseObject getBookById(int bookid) {
	ResponseObject res = new ResponseObject();
	Optional<Books> b = booksRepository.findById(bookid);
	if(b.isPresent()) {
		res.setMessage("Success");
		res.setData(b.get());
		res.setType("fetch");
		return res;
	} else {
		res.setMessage("Error");
		//res.setData();
		res.setType("fetch");
		return res;
	}
	
}



////getting all books record by using the method findaAll() of CrudRepository
//public List<Books> getAllBooks() 
//{
//List<Books> books = new ArrayList<Books>();
//booksRepository.findAll().forEach(books1 -> books.add(books1));
//return books;
//}
////getting a specific record by using the method findById() of CrudRepository
//public Books getBooksById(int id) 
//{
//return booksRepository.findById(id).get();
//}
////saving a specific record by using the method save() of CrudRepository
//public void saveOrUpdate(Books books) 
//{
//booksRepository.save(books);
//}
////deleting a specific record by using the method deleteById() of CrudRepository
//public void delete(int id) 
//{
//booksRepository.deleteById(id);
//}
////updating a record
//public void update(Books books, int bookid) 
//{
//booksRepository.save(books);
//}
}