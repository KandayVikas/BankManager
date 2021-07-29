package com.cg.bookmanager.service;

import java.util.List;

import com.cg.bookmanager.entity.Book;
import com.cg.bookmanager.exception.BookNotFoundException;

public interface BookService {

	public Book addBook(Book book);

	public String deleteByBookId(Long bookId) throws BookNotFoundException;

	public Book getBookById(Long bookId) throws BookNotFoundException;

	public List<Book> getBooks();

	public Book updateBook(Book book) throws BookNotFoundException;

}
