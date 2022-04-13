package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	 // adding the book repository as a dependency
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
    
 // deletes a book
    public Book deleteBook(Long id) {
    	Optional<Book> deleteBook = bookRepository.findById(id);
    	if(deleteBook.isPresent()){
    		bookRepository.deleteById(id);
    		return null;
    	}else {
    		return null;
    	}
		
    }
    
    // update a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> updateBook = bookRepository.findById(id);
    	if(updateBook.isPresent()){
    		Book thisBook = updateBook.get();
    		thisBook.setTitle(title);
    		thisBook.setDescription(desc);
    		thisBook.setLanguage(lang);
    		thisBook.setNumberOfPages(numOfPages);
    		bookRepository.save(thisBook);
    		return null;
    	} else {
    		return null;
    	}
		
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

}
