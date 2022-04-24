package com.capg.Controller;

import java.util.List;   
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.capg.Exception.ResourceNotFoundException;
import com.capg.Model.Book;
import com.capg.Service.BookService;

@RestController
@RequestMapping("/Book")
public class BookRestController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseEntity<String> addBookDetails(@Validated @RequestBody Book book) {
		Book bookResponse= bookService.addBook(book);
		return new ResponseEntity<String>(bookResponse.getBookId()+" has been inserted successfully ",HttpStatus.OK);
		
	}
	
    @GetMapping("/getAllBook")
	
	public ResponseEntity<List<Book>> fetchAllBook() {
		List<Book> bookObj=bookService.getAllBook();
		return new ResponseEntity<List<Book>>(bookObj,HttpStatus.OK);
	}
	
	
	@GetMapping("/getBookById")
	public ResponseEntity<Book> fetchBookById(@RequestParam("id") int id) {
		Optional<Book> book=  bookService.fetchBookById(id);
		return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
	}
	
	@PutMapping("/updateBookById")
	public ResponseEntity<String> updateBookById(@RequestBody Book bookId) {
		String status = null;
		Optional<Book> bookObj =  bookService.fetchBookById(bookId.getBookId());
		if (bookObj.isPresent()) {
			bookService.updateBookById(bookId);
			status = "Successfully Updated";
		} else {
			throw new ResourceNotFoundException("Given id it's not available in db..");

		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
}