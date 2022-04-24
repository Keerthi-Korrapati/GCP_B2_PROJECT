package com.capg.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.Model.Book;

@Repository
public interface BookRepo1 extends CrudRepository<Book, Integer>{

	Iterable<Book> findAll();
	
}
