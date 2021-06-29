package com.mika.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mika.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// this method retrieves all the books from the database
    List<Book> findAll();
    // this method finds books by id
    Optional<Book> findById(Long id);
    // this method deletes a book by id
    void deleteById(Long id);
	
	
}
