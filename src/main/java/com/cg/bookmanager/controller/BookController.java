package com.cg.bookmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmanager.entity.Book;
import com.cg.bookmanager.exception.BookNotFoundException;
import com.cg.bookmanager.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	public static boolean validate(@RequestHeader(value = "Authorization") String authorization) {
		String[] auth = authorization.split(" ");
		if (auth[1].equals("myauthcode"))
			return true;
		else
			return false;
	}

	// This method add products
	@PostMapping("/books")
	public ResponseEntity addBook(@RequestBody Book book,
			@RequestHeader(value = "Authorization") String authorization) {
		if (validate(authorization))
			return ResponseEntity.status(HttpStatus.OK).body(bookService.addBook(book));
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized access");
	}

	// deletebookbyid
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteByBookId(@PathVariable("id") Long bookId,
			@RequestHeader(value = "Authorization") String authorization) throws BookNotFoundException {
		if (validate(authorization))
			return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteByBookId(bookId));
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized access");
	}

	// find by book id
	@GetMapping("/book/{id}")
	public ResponseEntity getBookById(@PathVariable("id") Long bookId,
			@RequestHeader(value = "Authorization") String authorization) throws BookNotFoundException {
		if (validate(authorization))
			return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(bookId));
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized access");
	}

	// find all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(@RequestHeader(value = "Authorization") String authorization) {
		if (validate(authorization))
			return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
	}

	// update book
	@PutMapping("/books")
	public ResponseEntity updateBook(@RequestBody Book book,
			@RequestHeader(value = "Authorization") String authorization) throws BookNotFoundException {
		if (validate(authorization))
			return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(book));
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized access");
	}
}
