package com.cg.bookmanager.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long bookId;
	private String bookName;
	private String author;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dbupdate;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDbupdate() {
		return dbupdate;
	}
	public void setDbupdate(Date dbupdate) {
		this.dbupdate = dbupdate;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", dbupdate=" + dbupdate
				+ "]";
	}
	public Book(Long bookId, String bookName, String author, Date dbupdate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.dbupdate = dbupdate;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



}
