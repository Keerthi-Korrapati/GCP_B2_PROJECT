package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.capg.Model.Book;
import com.capg.Repository.BookRepo;
import com.capg.Service.BookService;
@SpringBootTest
public class BookTest {
	@MockBean
	private BookRepo repository;
	
	@Autowired
	private BookService service;
	@Test
	public void getAllBook() {
		when(repository.findAll()).thenReturn(Stream.of(new Book(1,"Java","James"),new Book(2,"Python","Guido")).collect(Collectors.toList()));
		assertEquals(2,service.getAllBook().size());
	}
	@Test
	public void getBookById() {
		int id=1;
		Optional<Book> b=Optional.ofNullable(new Book(1,"Python","Guido"));
		when(repository.findById(id)).thenReturn(Optional.ofNullable(new Book(1,"Python","Guido")));
		assertEquals(b.get().getBookId(),service.fetchBookById(id).get().getBookId());
	}
	
	@Test
	public void saveUser() {
		Book book=new Book(12,"C++","Bjarne");
		when(repository.save(book)).thenReturn(book);
		assertEquals(book,service.addBook(book));
	}
	

}
