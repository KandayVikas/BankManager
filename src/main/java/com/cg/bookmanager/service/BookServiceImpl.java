package com.cg.bookmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmanager.entity.Book;
import com.cg.bookmanager.exception.BookNotFoundException;
import com.cg.bookmanager.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public String deleteByBookId(Long bookId) throws BookNotFoundException {
		Optional<Book> optional = bookRepository.findById(bookId);
		if (!optional.isPresent())
			return new BookNotFoundException("Book details not found for id " + bookId).toString();
		else {
			Book book = optional.get();
			bookRepository.delete(book);
			return "deleted successfully";
		}
	}

	@Override
	public Book getBookById(Long bookId) throws BookNotFoundException {
		if(bookRepository.findById(bookId).get()==null)
			throw new BookNotFoundException("Book not found");
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {

		Long bookId = book.getBookId();
		if (bookRepository.existsById(bookId))
			return bookRepository.save(book);
		else
			throw new BookNotFoundException("Book not found");
	}
}
