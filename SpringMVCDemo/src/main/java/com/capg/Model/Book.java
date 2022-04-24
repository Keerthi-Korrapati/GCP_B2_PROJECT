package com.capg.Model;

import javax.persistence.Entity;   
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
		@Id
		private int bookId;
		
		@NotBlank
		@Size(min=2,message="name length should be min of 2")
		private String name;
		
		@NotBlank
		@Size(max=10,message="author name should be btn 1 to 10")
		private String authorName;
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public Book(int bookId, String name, String authorName) {
			super();
			this.bookId = bookId;
			this.name = name;
			this.authorName = authorName;
		}
		public Book() {
			super();
		}
		@Override
		public String toString() {
			return "Book [BookId=" + bookId + ", name=" + name + ", AuthorName=" + authorName + "]";
		}
		
		

	}
