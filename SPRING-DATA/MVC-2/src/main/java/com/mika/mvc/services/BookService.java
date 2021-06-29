package com.mika.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mika.mvc.models.Book;
import com.mika.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
	// updates a book
	public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    //updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> temp = bookRepository.findById(id);
    	if(temp != null) {
    		temp.get().setTitle(title);
    		temp.get().setDescription(desc);
    		temp.get().setLanguage(lang);
    		temp.get().setNumberOfPages(numOfPages);
    		return bookRepository.save(temp.get());
    	}
    	return null;
    }
    
 // deleted a book
 	public void deleteBook(Long id) {
 		bookRepository.deleteById(id);
 	}

	
}
