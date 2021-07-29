package com.cg.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmanager.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
