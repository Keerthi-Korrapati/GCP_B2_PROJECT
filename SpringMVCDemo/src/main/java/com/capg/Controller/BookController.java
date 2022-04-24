package com.capg.Controller;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capg.Model.Book;
import com.capg.Service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@RequestMapping("/home")
	public void home() {
		System.out.println("hello");
	}
	@RequestMapping("/addBook")
	@ResponseBody
	public Book addBookDetails(Book book) {
		Book bookResponse= bookService.addBook(book);
		return bookResponse;
		
	}
	
	@RequestMapping("/getBook")
	@ResponseBody
	public List<Book> fetchAllBook() {
		List<Book> bookObj=bookService.getAllBook();
		return bookObj;
	}
	
	
	/*
	 * @RequestMapping("/updateBook")
	 * 
	 * @ResponseBody public Book updateBookDetails(Book book) { Book
	 * bookResponse=bookService.updateBook(book); return bookResponse; }
	 */
	  
	/*
	 * @RequestMapping("/updateBookById") public ModelAndView
	 * updateBookById(@RequestParam("id") int id) { Optional<Book> book=
	 * bookService.updateBookById(id); ModelAndView mv =new ModelAndView();
	 * if(book.isPresent()) { mv.addObject("book", book.get());
	 * mv.setViewName("Book"); }else { mv.addObject("book",
	 * "Book is not available"); mv.setViewName("Book"); } return mv; }
	 */
		
	@RequestMapping("/fetchBookById")
	public ModelAndView fetchBookById(@RequestParam("id") int id) {
		Optional<Book> book = bookService.fetchBookById(id);
		ModelAndView mv = new ModelAndView();
		if (book.isPresent()) {
			mv.addObject("book", book.get());
			mv.setViewName("Book");
		} else {
			mv.addObject("book", "Book is not available");
			mv.setViewName("Book");
		}
		return mv;
	}
		 
}
