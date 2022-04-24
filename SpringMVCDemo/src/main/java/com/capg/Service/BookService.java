package com.capg.Service;


import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.capg.Model.Book;
import com.capg.Repository.BookRepo;
import com.capg.Repository.BookRepo1;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	BookRepo1 bookRepo1;
	
	public Book addBook(Book bookObj) {
		return bookRepo.save(bookObj);
	}

	public List<Book> getAllBook() {
		return  (List<Book>) bookRepo.findAll();
	}

	public List<Book> updateBook(Book bookObj1) { 
	   return (List<Book>) bookRepo1.save(bookObj1);
	}

	public Book updateBookById(Book bookId) { 
		return bookRepo.save(bookId);
	}
	 
	public Optional<Book> fetchBookById(int id) {
		// TODO Auto-generated method stub
		return  bookRepo.findById(id);
	}

}
