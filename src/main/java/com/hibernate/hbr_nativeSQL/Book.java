package com.hibernate.hbr_nativeSQL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	private int book_id;
	private String book_name;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int book_id, String book_name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Override
	public String toString() {
		return book_id + " : " + book_name;
	}

}
